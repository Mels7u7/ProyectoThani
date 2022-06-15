package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColComentarioProfesional", namespace ="ProjectThani")
public final  class StructSdtColComentarioProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtColComentarioProfesional( )
   {
      this( -1, new ModelContext( StructSdtColComentarioProfesional.class ));
   }

   public StructSdtColComentarioProfesional( int remoteHandle ,
                                             ModelContext context )
   {
   }

   public  StructSdtColComentarioProfesional( java.util.Vector<StructSdtComentarioProfesional> value )
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

   @javax.xml.bind.annotation.XmlElement(name="ComentarioProfesional",namespace="ProjectThani")
   public java.util.Vector<StructSdtComentarioProfesional> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtComentarioProfesional> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtComentarioProfesional> item = new java.util.Vector<>();
}

