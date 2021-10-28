/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Kiara Vaz. April 22nd 2019. This is the servlet where the java and jsp files communicate and pass information
package lessonFormHandler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KiaraVaz
 */
@WebServlet(name = "lessonServlet", loadOnStartup = 1, urlPatterns =
{
    "/voice",
    "/pickTeacher",
    "/signup",
    "/drum",
    "/piano",
    "/production",
    "/guitar",
    "/pickTeacher2",
    "/VBook",
    "/DBook",
    "/GBook",
    "/MPBook",
    "/PBook",
    "/aboutPage",
    "/index"

})

public class lessonServlet extends HttpServlet
{

    static String gusername = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet lessonServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet lessonServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        HttpSession session = request.getSession();
        String userPath = request.getServletPath();
        String myUrl;

        String name;
        String password;
        String time;
        String day;
        //String booked;
        boolean status = false;

        LoginBean loginBObj = new LoginBean();
        checkMethods checkObj = new checkMethods();

        //sends user to voice page where they pick the lesson. 
        if (userPath.equals("/voice"))
        {
            myUrl = "/WEB-INF" + userPath + ".jsp";
            try
            {
                request.getRequestDispatcher(myUrl).forward(request, response);
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }

            //sends user to drum page where they pick the lesson. 
        }

        if (userPath.equals("/index"))
        {
            myUrl = "index.html";
            try
            {
                request.getRequestDispatcher(myUrl).forward(request, response);
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }

            //sends user to drum page where they pick the lesson. 
        }

        if (userPath.equals("/aboutPage"))
        {
            myUrl = userPath + ".html";
            try
            {
                request.getRequestDispatcher(myUrl).forward(request, response);
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }

            //sends user to drum page where they pick the lesson. 
        } else if (userPath.equals("/drum"))
        {

            myUrl = "/WEB-INF" + userPath + ".jsp";

            try
            {
                request.getRequestDispatcher(myUrl).forward(request, response);
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }

            //key to sign the user up for a voice lesson
        } else if (userPath.equals("/VBook"))
        {
            try
            {
                insert objInsert = new insert();

                String booked;

                bookBean bookBObj = new bookBean();
                String selectionName = request.getParameter("name");
                String selectionDay = request.getParameter("day");
                String selectionTime = request.getParameter("time");
                
                
                if(selectionDay.equals(null)){
                    myUrl = "/WEB-INF/errorPage.jsp";
                        request.getRequestDispatcher(myUrl).forward(request, response); 
                }

                int testnameStatus = checkObj.checkEntry(selectionName);
                if (testnameStatus == 0)
                {

                    if ((selectionName.charAt(0) == ' '))
                    {
                        myUrl = "/WEB-INF/errorPage.jsp";
                        request.getRequestDispatcher(myUrl).forward(request, response);
                    }

                    bookBObj.setName(selectionName);
                    bookBObj.setDay(selectionDay);
                    bookBObj.setTime(selectionTime);
                    //gusername = loginBObj.getMyUsername();

                    if (objInsert.insertVoice(bookBObj).equals("insert"))
                    {
                        myUrl = "/WEB-INF" + "/book.jsp";

                        request.getRequestDispatcher(myUrl).forward(request, response);
                    } else if (objInsert.insertVoice(bookBObj).equals("noInsert"))
                    {
                        myUrl = "/WEB-INF" + "/notBooked.jsp";

                        try
                        {
                            request.getRequestDispatcher(myUrl).forward(request, response);
                        } catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }

                    }
                } else
                {
                    myUrl = "/WEB-INF/errorPage.jsp";
                    request.getRequestDispatcher(myUrl).forward(request, response);

                }
            } catch (Exception ex)
            {
                ex.printStackTrace();
                myUrl = "/WEB-INF/errorPage.jsp";
                request.getRequestDispatcher(myUrl).forward(request, response);

            }

            //key to sign the user up for a voice lesson
        } else if (userPath.equals("/DBook"))
        {
            try
            {
                insert objInsert = new insert();

                //LoginDao loginObj = new LoginDao();
                //loginBObj.setMyUsername(gusername);
                //name=loginBObj.getMyUsername();
                //String booked = objInsert.insertVoice(name, day, name);
//            name = request.getParameter("Name");
//            day = request.getParameter("Day");
//            time = request.getParameter("Time");
//            String booked;
//            name = "EThan";
//            day = "Monday";
//            time = "4pm";
                String booked;

                bookBean bookBObj = new bookBean();
                String selectionName = request.getParameter("name");
                String selectionDay = request.getParameter("day");
                String selectionTime = request.getParameter("time");

                int testnameStatus = checkObj.checkEntry(selectionName);
                if (testnameStatus == 0)
                {

                    if ((selectionName.charAt(0) == ' '))
                    {
                        myUrl = "/WEB-INF/errorPage.jsp";
                        request.getRequestDispatcher(myUrl).forward(request, response);
                    }

                    bookBObj.setName(selectionName);
                    bookBObj.setDay(selectionDay);
                    bookBObj.setTime(selectionTime);
                    //gusername = loginBObj.getMyUsername();

                    if (objInsert.insertDrum(bookBObj).equals("insert"))
                    {
                        myUrl = "/WEB-INF" + "/book.jsp";

                        request.getRequestDispatcher(myUrl).forward(request, response);
                    } else if (objInsert.insertDrum(bookBObj).equals("noInsert"))
                    {
                        myUrl = "/WEB-INF" + "/notBooked.jsp";

                        try
                        {
                            request.getRequestDispatcher(myUrl).forward(request, response);
                        } catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }

                    }
                } else
                {
                    myUrl = "/WEB-INF/errorPage.jsp";
                    request.getRequestDispatcher(myUrl).forward(request, response);

                }
            } catch (Exception ex)
            {
                ex.printStackTrace();
                myUrl = "/WEB-INF/errorPage.jsp";
                request.getRequestDispatcher(myUrl).forward(request, response);

            }

            //key to sign the user up for a guitar lesson
        } else if (userPath.equals("/GBook"))
        {
            try
            {
                insert objInsert = new insert();

                //LoginDao loginObj = new LoginDao();
                //loginBObj.setMyUsername(gusername);
                //name=loginBObj.getMyUsername();
                //String booked = objInsert.insertVoice(name, day, name);
//            name = request.getParameter("Name");
//            day = request.getParameter("Day");
//            time = request.getParameter("Time");
//            String booked;
//            name = "EThan";
//            day = "Monday";
//            time = "4pm";
                String booked;

                bookBean bookBObj = new bookBean();
                String selectionName = request.getParameter("name");
                String selectionDay = request.getParameter("day");
                String selectionTime = request.getParameter("time");

                if ((selectionName.charAt(0) == ' '))
                {
                    myUrl = "/WEB-INF/errorPage.jsp";
                    request.getRequestDispatcher(myUrl).forward(request, response);
                }

                int testnameStatus = checkObj.checkEntry(selectionName);
                if (testnameStatus == 0)
                {

                    bookBObj.setName(selectionName);
                    bookBObj.setDay(selectionDay);
                    bookBObj.setTime(selectionTime);
                    //gusername = loginBObj.getMyUsername();

                    if (objInsert.insertGuitar(bookBObj).equals("insert"))
                    {
                        myUrl = "/WEB-INF" + "/book.jsp";

                        request.getRequestDispatcher(myUrl).forward(request, response);
                    } else if (objInsert.insertGuitar(bookBObj).equals("noInsert"))
                    {
                        myUrl = "/WEB-INF" + "/notBooked.jsp";

                        try
                        {
                            request.getRequestDispatcher(myUrl).forward(request, response);
                        } catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }

                    }
                } else
                {
                    myUrl = "/WEB-INF/errorPage.jsp";
                    request.getRequestDispatcher(myUrl).forward(request, response);

                }
            } catch (Exception ex)
            {
                ex.printStackTrace();
                myUrl = "/WEB-INF/errorPage.jsp";
                request.getRequestDispatcher(myUrl).forward(request, response);

            }

            //key to sign the user up for a music production lesson
        } else if (userPath.equals("/MPBook"))
        {
            try
            {
                insert objInsert = new insert();

                //LoginDao loginObj = new LoginDao();
                //loginBObj.setMyUsername(gusername);
                //name=loginBObj.getMyUsername();
                //String booked = objInsert.insertVoice(name, day, name);
//            name = request.getParameter("Name");
//            day = request.getParameter("Day");
//            time = request.getParameter("Time");
//            String booked;
//            name = "EThan";
//            day = "Monday";
//            time = "4pm";
                String booked;

                bookBean bookBObj = new bookBean();
                String selectionName = request.getParameter("name");
                String selectionDay = request.getParameter("day");
                String selectionTime = request.getParameter("time");

                int testnameStatus = checkObj.checkEntry(selectionName);

                if (testnameStatus == 0)
                {
                    if ((selectionName.charAt(0) == ' '))
                    {
                        myUrl = "/WEB-INF/errorPage.jsp";
                        request.getRequestDispatcher(myUrl).forward(request, response);
                    }

                    bookBObj.setName(selectionName);
                    bookBObj.setDay(selectionDay);
                    bookBObj.setTime(selectionTime);
                    //gusername = loginBObj.getMyUsername();

                    if (objInsert.insertMProduction(bookBObj).equals("insert"))
                    {
                        myUrl = "/WEB-INF" + "/book.jsp";

                        request.getRequestDispatcher(myUrl).forward(request, response);
                    } else if (objInsert.insertMProduction(bookBObj).equals("noInsert"))
                    {
                        myUrl = "/WEB-INF" + "/notBooked.jsp";

                        try
                        {
                            request.getRequestDispatcher(myUrl).forward(request, response);
                        } catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }

                    }
                } else
                {
                    myUrl = "/WEB-INF/errorPage.jsp";
                    request.getRequestDispatcher(myUrl).forward(request, response);

                }
            } catch (Exception ex)
            {
                ex.printStackTrace();
                myUrl = "/WEB-INF/errorPage.jsp";
                request.getRequestDispatcher(myUrl).forward(request, response);

            }

            //key to sign the user up for a piano lesson
            //key to sign the user up for a piano lesson
        } else if (userPath.equals("/PBook"))
        {
            try
            {

                String testname = request.getParameter("name");
                String testday = request.getParameter("day");
                String testtime = request.getParameter("time");

                int testnameStatus = checkObj.checkEntry(testname);

                if (testnameStatus == 0)
                {

                    if ((testname.charAt(0) == ' '))
                    {
                        myUrl = "/WEB-INF/errorPage.jsp";
                        request.getRequestDispatcher(myUrl).forward(request, response);
                    }

                    bookBean bookBObj = new bookBean();
                    bookBObj.setName(testname);
                    bookBObj.setDay(testday);
                    bookBObj.setTime(testtime);
                    insert objInsert = new insert();
                    String booked = objInsert.insertPiano(bookBObj);

                    if (booked.equals("insert"))
                    {
                        myUrl = "/WEB-INF" + "/book.jsp";

                        request.getRequestDispatcher(myUrl).forward(request, response);
                    } else if (booked.equals("noInsert"))
                    {
                        myUrl = "/WEB-INF" + "/notBooked.jsp";

                        try
                        {
                            request.getRequestDispatcher(myUrl).forward(request, response);
                        } catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }
                    }
                } else
                {
                    myUrl = "/WEB-INF/errorPage.jsp";
                    request.getRequestDispatcher(myUrl).forward(request, response);

                }
            } catch (Exception ex)
            {
                ex.printStackTrace();
                myUrl = "/WEB-INF/errorPage.jsp";
                request.getRequestDispatcher(myUrl).forward(request, response);

            }

        } else if (userPath.equals("/piano"))
        {

            myUrl = "/WEB-INF" + userPath + ".jsp";

            try
            {
                request.getRequestDispatcher(myUrl).forward(request, response);
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }

            //sends user to music production page where they pick the lesson.    
        } else if (userPath.equals("/production"))
        {

            myUrl = "/WEB-INF" + userPath + ".jsp";

            try
            {
                request.getRequestDispatcher(myUrl).forward(request, response);
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }

            //sends user to guitar page where they pick the lesson. 
        } else if (userPath.equals("/guitar"))
        {

            myUrl = "/WEB-INF" + userPath + ".jsp";

            try
            {
                request.getRequestDispatcher(myUrl).forward(request, response);
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }

            //sends user to the page where they can pick lessons
        } else if (userPath.equals("/pickTeacher2"))
        {

            myUrl = "/WEB-INF" + userPath + ".jsp";

            try
            {
                request.getRequestDispatcher(myUrl).forward(request, response);
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }

            //login
        } else if (userPath.equals("/pickTeacher"))
        {
            try
            {

                LoginDao loginObj = new LoginDao();

                gusername = request.getParameter("myUsername");
                password = request.getParameter("myPassword");

                int usernameStatus = checkObj.checkEntry(gusername);
                int passwordStatus = checkObj.checkEntry(password);

                if (usernameStatus == 0 && passwordStatus == 0)
                {

                    if ((gusername.charAt(0) == ' '))
                    {
                        myUrl = "/WEB-INF/errorPage2.jsp";
                        request.getRequestDispatcher(myUrl).forward(request, response);
                    } else if ((password.charAt(0) == ' '))
                    {
                        myUrl = "/WEB-INF/errorPage2.jsp";
                        request.getRequestDispatcher(myUrl).forward(request, response);
                    }

                    loginBObj.setMyUsername(gusername);
                    loginBObj.setMyPassword(password);
                    //gusername = loginBObj.getMyUsername();

                    status = loginObj.validate(loginBObj);
                    if (status)
                    {
                        myUrl = "/WEB-INF" + userPath + ".jsp";
                        try
                        {

                            request.getRequestDispatcher(myUrl).forward(request, response);
                        } catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }

                    } else
                    {
                        myUrl = "WEB-INF" + "/tryAgain.jsp";
                        request.getRequestDispatcher(myUrl).forward(request, response);
                    }
                } else
                {

                    myUrl = "/WEB-INF/errorPage2.jsp";
                    request.getRequestDispatcher(myUrl).forward(request, response);
                }
            } catch (Exception ex)
            {
                ex.printStackTrace();
                myUrl = "/WEB-INF/errorPage2.jsp";
                request.getRequestDispatcher(myUrl).forward(request, response);

            }

        } //signup
        else if (userPath.equals("/signup"))
        {
            try
            {
                gusername = request.getParameter("myUsername");
                password = request.getParameter("myPassword");

                int usernameStatus = checkObj.checkEntry(gusername);
                int passwordStatus = checkObj.checkEntry(password);

                if (usernameStatus == 0 && passwordStatus == 0)
                {

                    if ((gusername.charAt(0) == ' '))
                    {
                        myUrl = "/WEB-INF/errorPage2.jsp";
                        request.getRequestDispatcher(myUrl).forward(request, response);
                    } else if ((password.charAt(0) == ' '))
                    {
                        myUrl = "/WEB-INF/errorPage2.jsp";
                        request.getRequestDispatcher(myUrl).forward(request, response);
                    }

                    loginBObj.setMyUsername(gusername);
                    loginBObj.setMyPassword(password);

                    SignupDao signUpObj = new SignupDao();

                    //gusername = loginBObj.getMyUsername();
                    //password = loginBObj.getMyPassword();
                    status = signUpObj.signup(loginBObj);

                    if (status)
                    {
                        myUrl = "/WEB-INF" + userPath + ".jsp";
                        try
                        {
                            request.getRequestDispatcher(myUrl).forward(request, response);
                        } catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }
                    } else
                    {
                        myUrl = "WEB-INF" + "/signinTryAgain.jsp";
                        request.getRequestDispatcher(myUrl).forward(request, response);
                    }
                } else
                {
                    myUrl = "/WEB-INF/errorPage2.jsp";
                    request.getRequestDispatcher(myUrl).forward(request, response);

                }

            } catch (Exception ex)
            {
                ex.printStackTrace();
                myUrl = "/WEB-INF/errorPage2.jsp";
                request.getRequestDispatcher(myUrl).forward(request, response);

            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
