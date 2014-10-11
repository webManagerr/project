/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.radixware.web.manager.Node;

/**
 *
 * @author Denis
 */
public class Tools {
    
    private static List<String> pages;
    
    static{
        pages = new ArrayList<String>();
        pages.add("workspace.jsp");
        pages.add("project.jsp");
        pages.add("list.jsp");
        pages.add("distribs.jsp");
        pages.add("distrib.jsp");
    }
    
    public static List<String> generateReference(Node element){
        int countParent = 0;
        Node parent = element;
        while ((parent = parent.getParent())!=null){
            countParent++;
        }
        List<String> result = new ArrayList<String>();
        result.add("<a>"+element.getName()+"</a>");
        parent = element;
        
        for (int i = countParent-1 , j= 0; i!=0; i-- ,j++){
            parent = parent.getParent();
            if(parent.getName().equals("Distribution Kits")){j--; continue;}
            result.add("<a href='"+ pages.get(i) +"?id="+parent.getId()+"'>"+parent.getName()+"</a>");
        }
       return result;

    }
}
