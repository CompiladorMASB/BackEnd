package Labels;

public class Label{

	private int[] list = new int[10000];

	private int getLabel(String line, int index, int pc){
		int i = index;
		int iLabel=0 ;
		String sLabel;
		while (line.charAt(i) != ':') i++;

		sLabel = line.substring(index+1, i);
		iLabel = Integer.parseInt(sLabel);
		list[iLabel] = pc;
		return i;
	}

	public void fillLabels(String line, int pc){
		int endIndex = line.lastIndexOf(":");
		int i=0, index=0;
		while (i < endIndex){
			index = getLabel(line, i, pc);
			i = index;
			i++;
		}
	}

	public String getPC(String label){
		int iLabel = Integer.parseInt(label);
		return Integer.toString(list[iLabel]);
	}

	public void printList(){
		int i=1;
		while (list[i] != 0){
			System.out.println("L" + i + ": " + list[i]);
			i++;
		}
	}
	
}