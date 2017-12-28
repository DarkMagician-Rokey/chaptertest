package com.neuedeu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ttc on 17-12-19.
 */
@WebServlet("/ServletQuestion")
public class ServletQuestion extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String phone = request.getParameter("name");
        String pass = request.getParameter("password");
        String captcha = request.getParameter("captcha");

        HttpSession hs = request.getSession();
        hs.setAttribute("id", phone);
        hs.setAttribute("password", pass);
        hs.setAttribute("captcha", captcha);

        List<QuestionInfo> li = getQuetionfromDB();

        System.out.println(li.get(0).getQuestionTitle());
        System.out.println(li.get(1).getQuestionTitle());

        hs.setAttribute("quizs", li);

        response.sendRedirect("/page/topicdynamics.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    public List<QuestionInfo> getQuetionfromDB()
    {
        List<QuestionInfo> li = new ArrayList<>();

        try
        {
            Connection conn = DBUtil.connedDB();
            String sql = "select question_title,question_introduce from question";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                String questiontitle = rs.getString("question_title");
                String questionintroduce = rs.getString("question_introduce");
                QuestionInfo qi = new QuestionInfo();
                qi.setQuestionTitle(questiontitle);
                qi.setQuestionIntroduce(questionintroduce);

                li.add(qi);
            }
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return li;
    }
}
