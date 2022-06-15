package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerElements_Element implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerElements_Element( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerElements_Element.class ));
   }

   public StructSdtQueryViewerElements_Element( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_SdtQueryViewerElements_Element_Name = "" ;
      gxTv_SdtQueryViewerElements_Element_Title = "" ;
      gxTv_SdtQueryViewerElements_Element_Visible = "" ;
      gxTv_SdtQueryViewerElements_Element_Type = "" ;
      gxTv_SdtQueryViewerElements_Element_Axis = "" ;
      gxTv_SdtQueryViewerElements_Element_Aggregation = "" ;
      gxTv_SdtQueryViewerElements_Element_Datafield = "" ;
      gxTv_SdtQueryViewerElements_Element_Filter_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Expandcollapse_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Axisorder_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(1) ;
      gxTv_SdtQueryViewerElements_Element_Actions_N = (byte)(1) ;
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

   public String getName( )
   {
      return gxTv_SdtQueryViewerElements_Element_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Name = value ;
   }

   public String getTitle( )
   {
      return gxTv_SdtQueryViewerElements_Element_Title ;
   }

   public void setTitle( String value )
   {
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Title = value ;
   }

   public String getVisible( )
   {
      return gxTv_SdtQueryViewerElements_Element_Visible ;
   }

   public void setVisible( String value )
   {
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Visible = value ;
   }

   public String getType( )
   {
      return gxTv_SdtQueryViewerElements_Element_Type ;
   }

   public void setType( String value )
   {
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Type = value ;
   }

   public String getAxis( )
   {
      return gxTv_SdtQueryViewerElements_Element_Axis ;
   }

   public void setAxis( String value )
   {
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Axis = value ;
   }

   public String getAggregation( )
   {
      return gxTv_SdtQueryViewerElements_Element_Aggregation ;
   }

   public void setAggregation( String value )
   {
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Aggregation = value ;
   }

   public String getDatafield( )
   {
      return gxTv_SdtQueryViewerElements_Element_Datafield ;
   }

   public void setDatafield( String value )
   {
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Datafield = value ;
   }

   public com.projectthani.StructSdtQueryViewerElements_Element_Filter getFilter( )
   {
      return gxTv_SdtQueryViewerElements_Element_Filter ;
   }

   public void setFilter( com.projectthani.StructSdtQueryViewerElements_Element_Filter value )
   {
      gxTv_SdtQueryViewerElements_Element_Filter_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Filter = value;
   }

   public com.projectthani.StructSdtQueryViewerElements_Element_ExpandCollapse getExpandcollapse( )
   {
      return gxTv_SdtQueryViewerElements_Element_Expandcollapse ;
   }

   public void setExpandcollapse( com.projectthani.StructSdtQueryViewerElements_Element_ExpandCollapse value )
   {
      gxTv_SdtQueryViewerElements_Element_Expandcollapse_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Expandcollapse = value;
   }

   public com.projectthani.StructSdtQueryViewerElements_Element_AxisOrder getAxisorder( )
   {
      return gxTv_SdtQueryViewerElements_Element_Axisorder ;
   }

   public void setAxisorder( com.projectthani.StructSdtQueryViewerElements_Element_AxisOrder value )
   {
      gxTv_SdtQueryViewerElements_Element_Axisorder_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Axisorder = value;
   }

   public com.projectthani.StructSdtQueryViewerElements_Element_Format getFormat( )
   {
      return gxTv_SdtQueryViewerElements_Element_Format ;
   }

   public void setFormat( com.projectthani.StructSdtQueryViewerElements_Element_Format value )
   {
      gxTv_SdtQueryViewerElements_Element_Format_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Format = value;
   }

   public com.projectthani.StructSdtQueryViewerElements_Element_Grouping getGrouping( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping ;
   }

   public void setGrouping( com.projectthani.StructSdtQueryViewerElements_Element_Grouping value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping = value;
   }

   public com.projectthani.StructSdtQueryViewerElements_Element_Actions getActions( )
   {
      return gxTv_SdtQueryViewerElements_Element_Actions ;
   }

   public void setActions( com.projectthani.StructSdtQueryViewerElements_Element_Actions value )
   {
      gxTv_SdtQueryViewerElements_Element_Actions_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Actions = value;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_Filter_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_Expandcollapse_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_Axisorder_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_Format_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_Grouping_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_Actions_N ;
   protected byte gxTv_SdtQueryViewerElements_Element_N ;
   protected String gxTv_SdtQueryViewerElements_Element_Name ;
   protected String gxTv_SdtQueryViewerElements_Element_Title ;
   protected String gxTv_SdtQueryViewerElements_Element_Visible ;
   protected String gxTv_SdtQueryViewerElements_Element_Type ;
   protected String gxTv_SdtQueryViewerElements_Element_Axis ;
   protected String gxTv_SdtQueryViewerElements_Element_Aggregation ;
   protected String gxTv_SdtQueryViewerElements_Element_Datafield ;
   protected com.projectthani.StructSdtQueryViewerElements_Element_Filter gxTv_SdtQueryViewerElements_Element_Filter=null ;
   protected com.projectthani.StructSdtQueryViewerElements_Element_ExpandCollapse gxTv_SdtQueryViewerElements_Element_Expandcollapse=null ;
   protected com.projectthani.StructSdtQueryViewerElements_Element_AxisOrder gxTv_SdtQueryViewerElements_Element_Axisorder=null ;
   protected com.projectthani.StructSdtQueryViewerElements_Element_Format gxTv_SdtQueryViewerElements_Element_Format=null ;
   protected com.projectthani.StructSdtQueryViewerElements_Element_Grouping gxTv_SdtQueryViewerElements_Element_Grouping=null ;
   protected com.projectthani.StructSdtQueryViewerElements_Element_Actions gxTv_SdtQueryViewerElements_Element_Actions=null ;
}

