package Linkage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
 * Servlet implementation class Linkage
 */
@WebServlet("/Linkage")
public class Linkage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Linkage() {
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
		response.setContentType("text/xml; charset=UTF-8");
		  //以下两句为取消在本地的缓存
		  response.setHeader("Cache-Control", "no-cache");
		  response.setHeader("Pragma", "no-cache");
		  PrintWriter out = response.getWriter();
		  String level1Id = request.getParameter("level1Id");
		  String level2Id = request.getParameter("level2Id");
//		  action=new String(action.getBytes("ISO-8859-1"),"gbk");//将获得的数据用gbk从新编码
		  Util util = new Util();
		  LinkageBean linkageBean = getTestLinkageBean();
		  
		  if(level1Id !=null && !level1Id.equals("")){
			  int intLevel1Id = new Integer(level1Id).intValue();
			  // TODO: Change here, get Level2List from DB by level1Id
			  List<Mst002Bean> mst002List = getMst002List(linkageBean, intLevel1Id); 
			  String outputLevel2Area = util.rebuiledLevel2Area(mst002List).toString();
			  out.write(outputLevel2Area);//注意这里向jsp输出的流，在script中的截获方法
		  }
		  else if(level2Id !=null && !level2Id.equals("")){
			  int intLevel2Id = new Integer(level2Id).intValue();
			  // TODO: Change here, get Level2List from DB by level1Id
			  List<Mst003Bean> mst003List = getMst003List(linkageBean, intLevel2Id); 
			  String outputLevel3Area = util.rebuiledLevel3Area(mst003List).toString();
			  out.write(outputLevel3Area);//注意这里向jsp输出的流，在script中的截获方法
		  }
		  
		 request.setAttribute("linkageBean", getTestLinkageBean());
		 request.setAttribute("testString", request.getParameter("testBox"));
		 request.getRequestDispatcher("/level.jsp").forward(request,response);
	}
	
	private List<Mst002Bean> getMst002List(LinkageBean linkageBean, int level1Id){
		List<Mst002Bean> mst002List = new ArrayList<Mst002Bean>();
		Iterator it = linkageBean.getMst002List().iterator();
		while (it.hasNext()) {
			Mst002Bean mst002Bean = (Mst002Bean) it.next();
			if(mst002Bean.getLevel1Id() == level1Id){
				mst002List.add(mst002Bean);
			}
		}
		return mst002List;
	}
	private List<Mst003Bean> getMst003List(LinkageBean linkageBean, int level2Id){
		List<Mst003Bean> mst003List = new ArrayList<Mst003Bean>();
		Iterator it = linkageBean.getMst003List().iterator();
		while (it.hasNext()) {
			Mst003Bean mst003Bean = (Mst003Bean) it.next();
			if(mst003Bean.getLevel2Id() == level2Id){
				mst003List.add(mst003Bean);
			}
		}
		return mst003List;
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
		linkageBean.getMst002List().add(new Mst002Bean(4,2,"ba"));
		linkageBean.getMst002List().add(new Mst002Bean(5,2,"bb"));
		linkageBean.getMst002List().add(new Mst002Bean(6,2,"bc"));
		// mst003List
		linkageBean.getMst003List().add(new Mst003Bean(1,1,"aaa"));
		linkageBean.getMst003List().add(new Mst003Bean(2,1,"aab"));
		linkageBean.getMst003List().add(new Mst003Bean(3,1,"aac"));
		linkageBean.getMst003List().add(new Mst003Bean(4,2,"aba"));
		linkageBean.getMst003List().add(new Mst003Bean(5,2,"aba"));
		linkageBean.getMst003List().add(new Mst003Bean(6,2,"aba"));
		return linkageBean;
	}
}
