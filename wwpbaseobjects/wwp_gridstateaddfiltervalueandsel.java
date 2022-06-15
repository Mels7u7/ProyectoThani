package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_gridstateaddfiltervalueandsel extends GXProcedure
{
   public wwp_gridstateaddfiltervalueandsel( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_gridstateaddfiltervalueandsel.class ), "" );
   }

   public wwp_gridstateaddfiltervalueandsel( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( com.projectthani.wwpbaseobjects.SdtWWPGridState[] aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        short aP3 ,
                        String aP4 ,
                        String aP5 ,
                        boolean aP6 ,
                        String aP7 ,
                        String aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( com.projectthani.wwpbaseobjects.SdtWWPGridState[] aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             String aP7 ,
                             String aP8 )
   {
      wwp_gridstateaddfiltervalueandsel.this.AV13GridState = aP0[0];
      this.aP0 = aP0;
      wwp_gridstateaddfiltervalueandsel.this.AV8FilterName = aP1;
      wwp_gridstateaddfiltervalueandsel.this.AV12AddFitler = aP2;
      wwp_gridstateaddfiltervalueandsel.this.AV15FilterOperator = aP3;
      wwp_gridstateaddfiltervalueandsel.this.AV11FilterValue = aP4;
      wwp_gridstateaddfiltervalueandsel.this.AV10FilterValueTo = aP5;
      wwp_gridstateaddfiltervalueandsel.this.AV16AddFitlerSel = aP6;
      wwp_gridstateaddfiltervalueandsel.this.AV17FilterValueSel = aP7;
      wwp_gridstateaddfiltervalueandsel.this.AV18FilterValueToSel = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV12AddFitler )
      {
         AV14GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( AV8FilterName );
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Operator( AV15FilterOperator );
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV11FilterValue );
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Valueto( AV10FilterValueTo );
         AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV14GridStateFilterValue, 0);
      }
      if ( AV16AddFitlerSel )
      {
         AV14GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( AV8FilterName+"_SEL" );
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV17FilterValueSel );
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Valueto( AV18FilterValueToSel );
         AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV14GridStateFilterValue, 0);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = wwp_gridstateaddfiltervalueandsel.this.AV13GridState;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15FilterOperator ;
   private short Gx_err ;
   private boolean AV12AddFitler ;
   private boolean AV16AddFitlerSel ;
   private String AV8FilterName ;
   private String AV11FilterValue ;
   private String AV10FilterValueTo ;
   private String AV17FilterValueSel ;
   private String AV18FilterValueToSel ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState[] aP0 ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV13GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV14GridStateFilterValue ;
}

