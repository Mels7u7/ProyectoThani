package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTMedicamentoGridItem", namespace ="ProjectThani")
public final  class StructSdtColSDTMedicamentoGridItem implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTMedicamentoGridItem( )
   {
      this( -1, new ModelContext( StructSdtColSDTMedicamentoGridItem.class ));
   }

   public StructSdtColSDTMedicamentoGridItem( int remoteHandle ,
                                              ModelContext context )
   {
   }

   public  StructSdtColSDTMedicamentoGridItem( java.util.Vector<StructSdtSDTMedicamentoGridItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTMedicamentoGridItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTMedicamentoGridItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTMedicamentoGridItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTMedicamentoGridItem> item = new java.util.Vector<>();
}

