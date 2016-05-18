package htea;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Utils {

	
//	public void test(){
//		File file = new File(".");
//		String[] list = file.list(new MyFilter());
//		
//		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
//		
//		for(String x: list){
//			System.out.println(x);
//		}
//	}
//	
//	private class MyFilter implements FilenameFilter{
//		@Override
//		public boolean accept(File dir, String name) {
//			
//			if(name.startsWith("."))
//				return true;
//			
//			return false;
//		}
//	}
	
//	local函数对 (目录)File 下所有目录和文件名进行正则匹配 
	public static File[] local(File dir, final String regex){
		return dir.listFiles(new FilenameFilter(){
			private Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(
						new File(name).getName()).matches();
			}
		});
	}
	
	public static File[] local(String path, final String regex){
		return local(new File(path), regex);
	}
	
	
//	文件目录树结构类，递归存放了目录下所有子目录和文件信息，目录和文件分别保存在List中
	public static class TreeInfo implements Iterable<File>{
		public List<File> files =  new ArrayList<File>();
		public List<File> dirs = new ArrayList<File>();
		
		@Override
		public Iterator<File> iterator() {
			return files.iterator();
		}
		
		public void addAll(TreeInfo other){
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}
		
		public String toString(){
			return "dirs: " + "files: ";
		}
		
//		打印所有文件
		public void showFiles(){
			for(File file: files){
				System.out.println(file);
			}
		}
		
//		打印所有子目录
		public void showSubdirs(){
			for(File dir: dirs){
				System.out.println(dir+"/");
			}
		}
		
	}
	
//	入口函数
	public static TreeInfo walk(String path, final String regex){
		return recurTree(new File(path), regex);
	}
	
//	目录递归
	private static TreeInfo recurTree(File dir, final String regex){
		TreeInfo result = new TreeInfo();
		for(File item: dir.listFiles()){
			if(item.isDirectory()){
				result.dirs.add(item);
				result.addAll(recurTree(item, regex));
			}else if(item.getName().matches(regex)){
				result.files.add(item);
			}
		}
		return result;
	}
	
	
}
