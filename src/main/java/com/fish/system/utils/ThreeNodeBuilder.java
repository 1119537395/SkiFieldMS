package com.fish.system.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ThreeNodeBuilder
 * @Description 树结构数据的封装
 * @Author 柚子茶
 * @Date 2020/12/1 10:39
 * @Version 1.0
 */
public class ThreeNodeBuilder {


	/**
	 * @param nodes    树节点
	 * @param rootNode 树的根节点
	 * @return List<ThreeNode>
	 * @description 将有序集合列封装成具有层级结构的树集合
	 * @author 柚子茶
	 * @date 2020/12/1 10:41
	 **/
	public static List<ThreeNode> builder(List<ThreeNode> nodes, Integer rootNode) {

		List<ThreeNode> threeNodeList = new ArrayList<>();

		for (ThreeNode node1 : nodes) {
			if (node1.getPid().equals(rootNode)){
				threeNodeList.add(node1);
			}
			for (ThreeNode node2 : nodes) {
				if (node2.getPid().equals(node1.getId())){
					node1.getChildren().add(node2);
				}
			}
		}

		return threeNodeList;
	}


}
