package htea;

import htea.Utils;

public class DirParser {
	
	public static void main(String[] args){

			Utils.TreeInfo treeInfo;
			treeInfo = Utils.walk(".",".*");
			treeInfo.showSubdirs();
			treeInfo.showFiles();
						
	//		for(File f: treeInfo.dirs){
	//			System.out.println(f.getPath()+"/");
	//		}
	//		for(File f: treeInfo.files){
	//			System.out.println(f.getName());
	//		}
			
			
		}

}

