/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.radixware.web.manager.DistributionKit;
import org.radixware.web.manager.ExternalProduct;
import org.radixware.web.manager.ExternalProducts;
import org.radixware.web.manager.Node;
import org.radixware.web.manager.Project;

/**
 *
 * @author Denis
 */
public class Tools {
    
    private static Map<Class,String> pages;
    
    private static void init(){
        pages = new HashMap<Class,String>();
        pages.put(Project.class,"project.jsp");
        pages.put(ExternalProducts.class,"list.jsp");
        pages.put(ExternalProduct.class,"list.jsp");
        pages.put(DistributionKit.class,"distrib.jsp");
    }
    
   
    
    public static List<String> generateReference(Node element){
        init();
        int countParent = 0;
        Node parent = element;
        while ((parent = parent.getParent())!=null){
            countParent++;
        }
        List<String> result = new ArrayList<String>();
        if(!element.getName().equals("Distribution Kits"))
            result.add("<a>"+element.getName()+"</a>");
        parent = element;
        
        for (int i = countParent-1 , j= 0; i!=0; i-- ,j++){
            parent = parent.getParent();
            if(parent.getName().equals("Distribution Kits")){j--; continue;}
            result.add("<a href='"+ pages.get(ListAdapter.getNodeClass(parent)) +"?id="+parent.getId()+"'>"+parent.getName()+"</a>");
        }
       return result;

    }
}
