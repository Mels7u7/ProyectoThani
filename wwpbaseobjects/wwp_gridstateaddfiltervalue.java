package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_gridstateaddfiltervalue extends GXProcedure
{
   public wwp_gridstateaddfiltervalue( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_gridstateaddfiltervalue.class ), "" );
   }

   public wwp_gridstateaddfiltervalue( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( com.projectthani.wwpbaseobjects.SdtWWPGridState[] aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        short aP3 ,
                        String aP4 ,
                        String aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( com.projectthani.wwpbaseobjects.SdtWWPGridState[] aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String aP5 )
   {
      wwp_gridstateaddfiltervalue.this.AV13GridState = aP0[0];
      this.aP0 = aP0;
      wwp_gridstateaddfiltervalue.this.AV8FilterName = aP1;
      wwp_gridstateaddfiltervalue.this.AV12AddFitler = aP2;
      wwp_gridstateaddfiltervalue.this.AV15FilterOperator = aP3;
      wwp_gridstateaddfiltervalue.this.AV11FilterValue = aP4;
      wwp_gridstateaddfiltervalue.this.AV10FilterValueTo = aP5;
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
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = wwp_gridstateaddfiltervalue.this.AV13GridState;
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
   private String AV8FilterName ;
   private String AV11FilterValue ;
   private String AV10FilterValueTo ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState[] aP0 ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV13GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV14GridStateFilterValue ;
}

