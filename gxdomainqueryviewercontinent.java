package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;

public final  class gxdomainqueryviewercontinent
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"Africa"), "Africa");
      domain.put(new String((String)"Antarctica"), "Antarctica");
      domain.put(new String((String)"Asia"), "Asia");
      domain.put(new String((String)"Europe"), "Europe");
      domain.put(new String((String)"NorthAmerica"), "North America");
      domain.put(new String((String)"Oceania"), "Oceania");
      domain.put(new String((String)"SouthAmerica"), "South America");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        String key )
   {
      if (domain.containsKey( key.trim() ))
      {
         return (String)domain.get( key.trim() );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<String> getValues( )
   {
      GXSimpleCollection<String> value = new GXSimpleCollection<String>(String.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((String) itr.next());
      }
      return value;
   }

}

