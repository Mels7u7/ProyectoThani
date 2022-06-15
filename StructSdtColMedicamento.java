package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColMedicamento", namespace ="ProjectThani")
public final  class StructSdtColMedicamento implements Cloneable, java.io.Serializable
{
   public StructSdtColMedicamento( )
   {
      this( -1, new ModelContext( StructSdtColMedicamento.class ));
   }

   public StructSdtColMedicamento( int remoteHandle ,
                                   ModelContext context )
   {
   }

   public  StructSdtColMedicamento( java.util.Vector<StructSdtMedicamento> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Medicamento",namespace="ProjectThani")
   public java.util.Vector<StructSdtMedicamento> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtMedicamento> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtMedicamento> item = new java.util.Vector<>();
}

