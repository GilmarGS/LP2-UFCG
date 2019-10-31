package  revisao2;

import java.util.Comparator;

public class ComparaMonitor implements Comparator<Monitor>{

	@Override
	public int compare(Monitor o1, Monitor o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
