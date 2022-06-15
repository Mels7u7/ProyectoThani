package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;

public final  class gxdomainqueryvieweraxisordertype
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"None"), "None");
      domain.put(new String((String)"Ascending"), "Ascending");
      domain.put(new String((String)"Descending"), "Descending");
      domain.put(new String((String)"Custom"), "Custom");
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

