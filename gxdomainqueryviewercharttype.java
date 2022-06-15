package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;

public final  class gxdomainqueryviewercharttype
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"Column"), "Column");
      domain.put(new String((String)"Column3D"), "Column 3D");
      domain.put(new String((String)"StackedColumn"), "Stacked column");
      domain.put(new String((String)"StackedColumn3D"), "Stacked column 3D");
      domain.put(new String((String)"StackedColumn100"), "100% stacked column");
      domain.put(new String((String)"Bar"), "Bar");
      domain.put(new String((String)"StackedBar"), "Stacked bar");
      domain.put(new String((String)"StackedBar100"), "100% stacked bar");
      domain.put(new String((String)"Area"), "Area");
      domain.put(new String((String)"StackedArea"), "Stacked area");
      domain.put(new String((String)"StackedArea100"), "100% stacked area");
      domain.put(new String((String)"SmoothArea"), "Smooth area");
      domain.put(new String((String)"StepArea"), "Step area");
      domain.put(new String((String)"Line"), "Line");
      domain.put(new String((String)"StackedLine"), "Stacked line");
      domain.put(new String((String)"StackedLine100"), "100% stacked line");
      domain.put(new String((String)"SmoothLine"), "Smooth line");
      domain.put(new String((String)"StepLine"), "Step line");
      domain.put(new String((String)"Pie"), "Pie");
      domain.put(new String((String)"Pie3D"), "Pie 3D");
      domain.put(new String((String)"Doughnut"), "Doughnut");
      domain.put(new String((String)"Doughnut3D"), "Doughnut 3D");
      domain.put(new String((String)"LinearGauge"), "Linear gauge");
      domain.put(new String((String)"CircularGauge"), "Circular gauge");
      domain.put(new String((String)"Radar"), "Radar");
      domain.put(new String((String)"FilledRadar"), "Filled radar");
      domain.put(new String((String)"PolarArea"), "Polar area");
      domain.put(new String((String)"Funnel"), "Funnel");
      domain.put(new String((String)"Pyramid"), "Pyramid");
      domain.put(new String((String)"ColumnLine"), "Column & line");
      domain.put(new String((String)"Column3DLine"), "Column 3D & line");
      domain.put(new String((String)"Timeline"), "Timeline");
      domain.put(new String((String)"SmoothTimeline"), "Smooth timeline");
      domain.put(new String((String)"StepTimeline"), "Step timeline");
      domain.put(new String((String)"Sparkline"), "Sparkline");
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

