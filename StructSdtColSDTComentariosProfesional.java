package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTComentariosProfesional", namespace ="ProjectThani")
public final  class StructSdtColSDTComentariosProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTComentariosProfesional( )
   {
      this( -1, new ModelContext( StructSdtColSDTComentariosProfesional.class ));
   }

   public StructSdtColSDTComentariosProfesional( int remoteHandle ,
                                                 ModelContext context )
   {
   }

   public  StructSdtColSDTComentariosProfesional( java.util.Vector<StructSdtSDTComentariosProfesional> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTComentariosProfesional",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTComentariosProfesional> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTComentariosProfesional> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTComentariosProfesional> item = new java.util.Vector<>();
}

