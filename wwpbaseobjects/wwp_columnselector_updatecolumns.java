package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_columnselector_updatecolumns extends GXProcedure
{
   public wwp_columnselector_updatecolumns( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_columnselector_updatecolumns.class ), "" );
   }

   public wwp_columnselector_updatecolumns( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector executeUdp( com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[] aP0 )
   {
      wwp_columnselector_updatecolumns.this.aP1 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[] {new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[] aP0 ,
                        com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[] aP0 ,
                             com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[] aP1 )
   {
      wwp_columnselector_updatecolumns.this.AV15OldColumnsSelector = aP0[0];
      this.aP0 = aP0;
      wwp_columnselector_updatecolumns.this.AV11ColumnsSelector = aP1[0];
      this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV19GXV1 = 1 ;
      while ( AV19GXV1 <= AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV8Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV19GXV1));
         /* Execute user subroutine: 'ISCOLUMNVISIBLE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( AV13Found )
         {
            AV8Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( AV14IsColumnVisible );
            AV8Column.setgxTv_SdtWWPColumnsSelector_Column_Order( AV16ColumnOrder );
         }
         AV19GXV1 = (int)(AV19GXV1+1) ;
      }
      AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV16ColumnOrder = (short)(0) ;
      AV20GXV2 = 1 ;
      while ( AV20GXV2 <= AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV8Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV11ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV20GXV2));
         AV8Column.setgxTv_SdtWWPColumnsSelector_Column_Order( AV16ColumnOrder );
         AV16ColumnOrder = (short)(AV16ColumnOrder+1) ;
         AV20GXV2 = (int)(AV20GXV2+1) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ISCOLUMNVISIBLE' Routine */
      returnInSub = false ;
      AV13Found = false ;
      AV21GXV3 = 1 ;
      while ( AV21GXV3 <= AV15OldColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV10ColumnAux = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV15OldColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV21GXV3));
         if ( GXutil.strcmp(AV8Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), AV10ColumnAux.getgxTv_SdtWWPColumnsSelector_Column_Columnname()) == 0 )
         {
            AV14IsColumnVisible = AV10ColumnAux.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ;
            AV16ColumnOrder = AV10ColumnAux.getgxTv_SdtWWPColumnsSelector_Column_Order() ;
            AV13Found = true ;
            if (true) break;
         }
         AV21GXV3 = (int)(AV21GXV3+1) ;
      }
   }

   protected void cleanup( )
   {
      this.aP0[0] = wwp_columnselector_updatecolumns.this.AV15OldColumnsSelector;
      this.aP1[0] = wwp_columnselector_updatecolumns.this.AV11ColumnsSelector;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV10ColumnAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV16ColumnOrder ;
   private short Gx_err ;
   private int AV19GXV1 ;
   private int AV20GXV2 ;
   private int AV21GXV3 ;
   private boolean returnInSub ;
   private boolean AV13Found ;
   private boolean AV14IsColumnVisible ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[] aP1 ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[] aP0 ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV15OldColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV11ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column AV8Column ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column AV10ColumnAux ;
}

