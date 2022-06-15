package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColRatingProfesional", namespace ="ProjectThani")
public final  class StructSdtColRatingProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtColRatingProfesional( )
   {
      this( -1, new ModelContext( StructSdtColRatingProfesional.class ));
   }

   public StructSdtColRatingProfesional( int remoteHandle ,
                                         ModelContext context )
   {
   }

   public  StructSdtColRatingProfesional( java.util.Vector<StructSdtRatingProfesional> value )
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

   @javax.xml.bind.annotation.XmlElement(name="RatingProfesional",namespace="ProjectThani")
   public java.util.Vector<StructSdtRatingProfesional> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtRatingProfesional> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtRatingProfesional> item = new java.util.Vector<>();
}

