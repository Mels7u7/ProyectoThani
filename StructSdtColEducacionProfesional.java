package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColEducacionProfesional", namespace ="ProjectThani")
public final  class StructSdtColEducacionProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtColEducacionProfesional( )
   {
      this( -1, new ModelContext( StructSdtColEducacionProfesional.class ));
   }

   public StructSdtColEducacionProfesional( int remoteHandle ,
                                            ModelContext context )
   {
   }

   public  StructSdtColEducacionProfesional( java.util.Vector<StructSdtEducacionProfesional> value )
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

   @javax.xml.bind.annotation.XmlElement(name="EducacionProfesional",namespace="ProjectThani")
   public java.util.Vector<StructSdtEducacionProfesional> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtEducacionProfesional> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtEducacionProfesional> item = new java.util.Vector<>();
}

