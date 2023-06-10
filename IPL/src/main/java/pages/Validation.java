package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.Local;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import pojo.Player;
import pojo.Team;

/**
 * Servlet implementation class Validation
 */
@WebServlet("/validate")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			
			HttpSession hs = request.getSession();
			String teamId = request.getParameter("team_id");
			TeamDaoImpl team = (TeamDaoImpl) hs.getAttribute("team_dao");
			PlayerDaoImpl player = (PlayerDaoImpl) hs.getAttribute("player_dao");
		int player_id = Integer.parseInt(request.getParameter("team_id"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		LocalDate inputdate= LocalDate.parse(request.getParameter("dob"));
		double battingAvg  = Double.parseDouble(request.getParameter("avg"));
		int wickets_taken = Integer.parseInt(request.getParameter("wickets"));
		int team_id = Integer.parseInt(request.getParameter("team_id"));
		
		Player newPlayer= new Player( first_name, last_name, Date.valueOf(inputdate), battingAvg, wickets_taken, team_id);
		Integer agePlayer= Period.between(inputdate, LocalDate.now()).getYears();
		try(PrintWriter pw = response.getWriter())
		{
			System.out.println("ageplayer "+ agePlayer);
			System.out.println("newplayer batting avg:" +newPlayer.getBatting_avg());
			System.out.println("newplayer wickets taken "+ newPlayer.getWickets_taken());
			if(agePlayer <= team.getSelectedTeamDetails(team_id).getMaxAge()
					&& newPlayer.getBatting_avg()>= team.getSelectedTeamDetails(team_id).getBattingAvg()
					&& newPlayer.getWickets_taken()>= team.getSelectedTeamDetails(team_id).getWicketsTaken())	
			{
				player.addPlayer(newPlayer);
			pw.print("<h1>player added</h1>");
			}
			else
				pw.print("<h1>player not added</h1>");
			
			
		}
		}
		catch (Exception e) {
			throw new ServletException("error in " + e.getMessage(), e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	

}
