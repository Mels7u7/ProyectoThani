package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTDiagnosticoGrid", namespace ="ProjectThani")
public final  class StructSdtColSDTDiagnosticoGrid implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTDiagnosticoGrid( )
   {
      this( -1, new ModelContext( StructSdtColSDTDiagnosticoGrid.class ));
   }

   public StructSdtColSDTDiagnosticoGrid( int remoteHandle ,
                                          ModelContext context )
   {
   }

   public  StructSdtColSDTDiagnosticoGrid( java.util.Vector<StructSdtSDTDiagnosticoGrid> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @javax.xml.bind.annotation.XmlElement(name="SDTDiagnosticoGrid",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTDiagnosticoGrid> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTDiagnosticoGrid> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTDiagnosticoGrid> item = new java.util.Vector<>();
}

