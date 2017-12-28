package com.neuedeu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by ttc on 17-12-19.
 */
@WebServlet("/ServletGetQuestion")
public class ServletGetQuestion extends HttpServlet
{
    private int id = 50;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        //问题标题
        String questionTitle = request.getParameter("questionTitle");
        //添加话题
        String questionTopic = request.getParameter("questionTopic");
        //问题描述
        String questionIntroduce = request.getParameter("questionIntroduce");

        QuestionInfo q = new QuestionInfo();

        q.setQuestionTitle(questionTitle);
        q.setQuestionIntroduce(questionIntroduce);


        insertIntoDB(q);


    }

    private void insertIntoDB(QuestionInfo q)
    {
        String questionTitle = q.getQuestionTitle();
        String questionIntroduce = q.getQuestionIntroduce();

        try
        {
            Connection conn = DBUtil.connedDB();
            String sql = "insert into question (question_id,question_title,question_introduce,question_create_time) values (?,?,?,sysdate)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id++);
            ps.setString(2, questionTitle);
            ps.setString(3, questionIntroduce);

            ps.executeQuery();

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
