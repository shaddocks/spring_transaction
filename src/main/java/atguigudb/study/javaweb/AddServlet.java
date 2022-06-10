package atguigudb.study.javaweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; //javax改为jakarta
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AddServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("开始初始化...");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //改成Public 请求包装为req对象
        //super.doPost(req, resp); 记得注释
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        System.out.println("Session ID: " + session.getId());
        String fName = req.getParameter("fName");
        double price = Double.parseDouble(req.getParameter("price"));
        double fCount = Double.parseDouble(req.getParameter("fCount"));
        String remark = req.getParameter("remark");

        System.out.println(fName);
    }

    @Override
    public void destroy() {
        System.out.println("正在销毁...");
    }
}
