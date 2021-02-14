package springboot.backend.apirest.paginator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import springboot.backend.apirest.paginator.PageItem;

public class PageRender<T> {
private String url;
private Page<T> page;

private int totalPaginas;
private int numElementosPagina;
private int paginaActual;
private List<PageItem>paginas;


public PageRender(String url, Page<T> page) {
	
	this.url = url;
	this.page = page;
	this.paginas = new ArrayList<PageItem>();
	
	
	
	numElementosPagina=page.getSize();
	totalPaginas = page.getTotalPages();
	paginaActual= page.getNumber();
	
	int desde,hasta;
	if (totalPaginas<=numElementosPagina) {
		desde=1;
		hasta=totalPaginas;
	}else {
		if (paginaActual<=numElementosPagina/2) {
			desde=1;
			hasta=numElementosPagina;
		}else if (paginaActual>=totalPaginas-numElementosPagina/2) {
			desde=totalPaginas-numElementosPagina+1;
			hasta= numElementosPagina;
		}else {
			desde= paginaActual-numElementosPagina/2;
			hasta = numElementosPagina;
		}
	}
	
	for (int i = 0; i < hasta; i++) {
		paginas.add(new PageItem(desde +i,paginaActual==desde+i));
	}
	
}


public String getUrl() {
	return url;
}


public int getTotalPaginas() {
	return totalPaginas;
}


public int getPaginaActual() {
	return paginaActual;
}


public List<PageItem> getPaginas() {
	return paginas;
}

public boolean isFirst() {
	return page.isFirst();
}

public boolean isLast() {
	return page.isLast();
}

public boolean isHasNext() {
	return page.hasNext();
}

public boolean isHasPrevious() {
	return page.hasPrevious();
}



}
