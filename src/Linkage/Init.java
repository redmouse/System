package Linkage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.LinkageBean;
import Bean.Mst001Bean;
import Bean.Mst002Bean;
import Bean.Mst003Bean;

/**
 * Servlet implementation class Init
 */
@WebServlet("/Init")
public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Init() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("linkageBean", getTestLinkageBean());
		request.getRequestDispatcher("/level.jsp").forward(request,response);
	}

	private LinkageBean getTestLinkageBean(){
		LinkageBean linkageBean = new LinkageBean();
		// mst001List
		linkageBean.getMst001List().add(new Mst001Bean(1,"a"));
		linkageBean.getMst001List().add(new Mst001Bean(2,"b"));
		linkageBean.getMst001List().add(new Mst001Bean(3,"c"));
		// mst002List
		linkageBean.getMst002List().add(new Mst002Bean(1,1,"aa"));
		linkageBean.getMst002List().add(new Mst002Bean(2,1,"ab"));
		linkageBean.getMst002List().add(new Mst002Bean(3,1,"ac"));
		// mst003List
		linkageBean.getMst003List().add(new Mst003Bean(1,1,"aaa"));
		linkageBean.getMst003List().add(new Mst003Bean(2,1,"aab"));
		linkageBean.getMst003List().add(new Mst003Bean(3,1,"aac"));

		
		linkageBean.setSelectedLevel1Id(1);
		linkageBean.setSelectedLevel2Id(1);
		linkageBean.setSelectedLevel3Id(2);
		return linkageBean;
	}
}
