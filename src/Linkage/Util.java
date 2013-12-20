package Linkage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Bean.Mst002Bean;
import Bean.Mst003Bean;

public class Util {

	public StringBuffer rebuiledLevel2Area(List<Mst002Bean> mst002List) {
		// replace level2Area
		StringBuffer sb = new StringBuffer();
		sb.append("<select id='level2Id'  onChange='level2_changed()'>");
		sb.append("<option value ='0'>選択</option>");
		Iterator it = mst002List.iterator();
		while (it.hasNext()) {
			Mst002Bean mst002Bean = (Mst002Bean) it.next();
				sb.append("<option value ='" + mst002Bean.getLevel2Id() + "'>"
						+ mst002Bean.getName() + "</option>");
		}
		sb.append("</select>");
		sb.append("<span id='level3Area'>");
		sb.append(rebuiledLevel3Area(new ArrayList<Mst003Bean>()));
		sb.append("</span>");
		return sb;
	}
	public StringBuffer rebuiledLevel3Area(List<Mst003Bean> mst003List) {
		// replace level2Area
		StringBuffer sb = new StringBuffer();
		sb.append("<select id='level3Id'>");
		sb.append("<option value ='0'>選択</option>");
		Iterator it = mst003List.iterator();
		while (it.hasNext()) {
			Mst003Bean mst003Bean = (Mst003Bean) it.next();
				sb.append("<option value ='" + mst003Bean.getLevel3Id() + "'>"
						+ mst003Bean.getName() + "</option>");
		}
		sb.append("</select>");
		return sb;
	}
}
