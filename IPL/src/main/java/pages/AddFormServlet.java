package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImpl;
import dao.TeamDao;
import dao.TeamDaoImpl;
import pojo.Team;

/**
 * Servlet implementation class AddFormServlet
 */
@WebServlet(value ="/add_player_form",loadOnStartup =1)
public class AddFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamDao teamDao;
	private PlayerDaoImpl playerDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init() throws ServletException
    {
    	
    	try {
    		teamDao= new TeamDaoImpl();
    		playerDao = new PlayerDaoImpl();
    	}
    	catch (Exception e) {
    		throw new ServletException("err in init"+ getClass(),e);
		}
    }
    public void destroy()
    {	
    	try {
    		((TeamDaoImpl) teamDao).cleanUp();
    		playerDao.cleanUp();
    	}
    	catch (Exception e) {
    		System.out.println("err in destroy"+e);
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try(PrintWriter pw= response.getWriter())
		{
			HttpSession hs = request.getSession();
			//add daos under session dscope
			hs.setAttribute("team_dao", teamDao);
			hs.setAttribute("player_dao", playerDao);
			
			List<Team> allTeams= teamDao.getlAllTeams();
			pw.print("<h3 align='center'>player selectionform</h3>");
			pw.print("<form action='validate'>");
			pw.print("<h5>");
			pw.print("Choose Team : <select name='team_id'>");
			for (Team team : allTeams)
				pw.print("<option value='" + team.getTeamId() 
				+ "'>" + team.getAbbrevation() + "</option>");
			pw.print("</select>");
			pw.print("</h5>");
			pw.print("<h5>Player Name <input type='text' name='first_name'/></h5>");
			pw.print("<h5>Player Name <input type='text' name='last_name'/></h5>");
			pw.print("<h5>Player DoB <input type='date' name='dob'/></h5>");
			pw.print("<h5>Batting Avg <input type='number' name='avg'/></h5>");
			pw.print("<h5>Wickets Taken <input type='number' name='wickets'/></h5>");
			pw.print("<h5><input type='submit' value='Add Player'/></h5>");
			pw.print("</form>");
		}
		catch (Exception e) {
			throw new ServletException("err in doGet"+ getClass(), e);
		}
	}

}
