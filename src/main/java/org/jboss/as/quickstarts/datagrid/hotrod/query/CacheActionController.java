package org.jboss.as.quickstarts.datagrid.hotrod.query;

import org.jboss.as.quickstarts.datagrid.hotrod.query.domain.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheActionController {
	
	@Autowired
	SnowForecast sf;
	
	@RequestMapping(value="addData", method=RequestMethod.POST)
	public String addData(@RequestBody Forecast fst) {
		sf.addForecastNew(fst);
		System.out.println("Added ID is"+ fst.getId());
		return "Added ID is"+ fst.getId();
	}
	
	@RequestMapping(value="removeData", method=RequestMethod.DELETE)
	public String removeData(@RequestBody String id) {
		sf.removeForecastNew(Integer.parseInt(id));
		return "Removed ID is"+ id;
	}
	
	@RequestMapping(value="getAll", method=RequestMethod.GET)
	public String printAllEntries() {
		return sf.printAllEntriesNew();
	}
	@RequestMapping(value="snowReport", method=RequestMethod.GET)
	public String printSnowreport() {
		return sf.printSnowReportNew();
	}

}
