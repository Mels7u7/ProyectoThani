package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;

public final  class gxdomainqueryviewertrendperiod
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"SinceTheBeginning"), "Since the beginning");
      domain.put(new String((String)"LastYear"), "Last year");
      domain.put(new String((String)"LastSemester"), "Last semester");
      domain.put(new String((String)"LastQuarter"), "Last quarter");
      domain.put(new String((String)"LastMonth"), "Last month");
      domain.put(new String((String)"LastWeek"), "Last week");
      domain.put(new String((String)"LastDay"), "Last day");
      domain.put(new String((String)"LastHour"), "Last hour");
      domain.put(new String((String)"LastMinute"), "Last minute");
      domain.put(new String((String)"LastSecond"), "Last second");
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

