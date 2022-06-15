package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;

public final  class gxdomainqueryvieweraggregationtype
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"Sum"), "Sum");
      domain.put(new String((String)"Count"), "Count");
      domain.put(new String((String)"Average"), "Average");
      domain.put(new String((String)"Max"), "Max");
      domain.put(new String((String)"Min"), "Min");
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

