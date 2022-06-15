package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTMedicamentoData", namespace ="ProjectThani")
public final  class StructSdtColSDTMedicamentoData implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTMedicamentoData( )
   {
      this( -1, new ModelContext( StructSdtColSDTMedicamentoData.class ));
   }

   public StructSdtColSDTMedicamentoData( int remoteHandle ,
                                          ModelContext context )
   {
   }

   public  StructSdtColSDTMedicamentoData( java.util.Vector<StructSdtSDTMedicamentoData> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTMedicamentoData",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTMedicamentoData> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTMedicamentoData> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTMedicamentoData> item = new java.util.Vector<>();
}

