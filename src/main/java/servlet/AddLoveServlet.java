package servlet;

import entity.Love;
import entity.Music;
import factory.DaoFactory;
import factory.ServiceFactory;
import service.LoveService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "AddLoveServlet")
public class AddLoveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String musicId = request.getParameter("musicId");
        String loveName = request.getParameter("loveName");
        String userId = request.getParameter("userId");
        List<Love>loves = ServiceFactory.getLoveService().findLovesByUserId(userId);
        for(Love l:loves)
        {
            if(l.getLoveName().equals(loveName))
            {
              List<Music> musics = ServiceFactory.getLoveService().findMusicsInLove(l);
              for(Music m:musics) {
                  if (m.getMusicId().equals(musicId)){
                      out.write("music exists");
                  }
              }
            }
        }
        Love love = new Love(UUID.randomUUID().toString(),loveName,userId,musicId);
        DaoFactory.getLoveDaoImpl().addLove(love);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
