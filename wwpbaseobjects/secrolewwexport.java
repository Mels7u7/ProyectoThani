package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secrolewwexport extends GXProcedure
{
   public secrolewwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secrolewwexport.class ), "" );
   }

   public secrolewwexport( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      secrolewwexport.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      secrolewwexport.this.aP0 = aP0;
      secrolewwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecRole", GXv_boolean2) ;
      secrolewwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV55Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV50WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV50WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'OPENDOCUMENT' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV13CellRow = 1 ;
         AV14FirstColumn = 1 ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S191 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEFILTERS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITECOLUMNTITLES' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEDATA' */
         S151 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'CLOSEDOCUMENT' */
         S181 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV15Random = (int)(GXutil.random( )*10000) ;
      AV11Filename = "SecRoleWWExport-" + GXutil.trim( GXutil.str( AV15Random, 8, 0)) + ".xlsx" ;
      AV10ExcelDocument.Open(AV11Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV10ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( (GXutil.strcmp("", AV52FilterFullText)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Filter") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secrolewwexport.this.AV13CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52FilterFullText, GXv_char7) ;
         secrolewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (GXutil.strcmp("", AV36TFSecRoleName_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Name") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secrolewwexport.this.AV13CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFSecRoleName_Sel, GXv_char7) ;
         secrolewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV35TFSecRoleName)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Name") ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secrolewwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV35TFSecRoleName, GXv_char7) ;
            secrolewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV38TFSecRoleDescription_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Description") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secrolewwexport.this.AV13CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFSecRoleDescription_Sel, GXv_char7) ;
         secrolewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFSecRoleDescription)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Description") ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secrolewwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFSecRoleDescription, GXv_char7) ;
            secrolewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV13CellRow = (int)(AV13CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+0, 1, 1).setBold( (short)(1) );
      AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+0, 1, 1).setColor( 11 );
      AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+0, 1, 1).setText( "Name" );
      AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setBold( (short)(1) );
      AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setColor( 11 );
      AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "Description" );
   }

   public void S151( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV57Wwpbaseobjects_secrolewwds_1_filterfulltext = AV52FilterFullText ;
      AV58Wwpbaseobjects_secrolewwds_2_tfsecrolename = AV35TFSecRoleName ;
      AV59Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel = AV36TFSecRoleName_Sel ;
      AV60Wwpbaseobjects_secrolewwds_4_tfsecroledescription = AV37TFSecRoleDescription ;
      AV61Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel = AV38TFSecRoleDescription_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV57Wwpbaseobjects_secrolewwds_1_filterfulltext ,
                                           AV59Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel ,
                                           AV58Wwpbaseobjects_secrolewwds_2_tfsecrolename ,
                                           AV61Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel ,
                                           AV60Wwpbaseobjects_secrolewwds_4_tfsecroledescription ,
                                           A13SecRoleName ,
                                           A12SecRoleDescription ,
                                           Short.valueOf(AV16OrderedBy) ,
                                           Boolean.valueOf(AV17OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV57Wwpbaseobjects_secrolewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Wwpbaseobjects_secrolewwds_1_filterfulltext), "%", "") ;
      lV57Wwpbaseobjects_secrolewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV57Wwpbaseobjects_secrolewwds_1_filterfulltext), "%", "") ;
      lV58Wwpbaseobjects_secrolewwds_2_tfsecrolename = GXutil.concat( GXutil.rtrim( AV58Wwpbaseobjects_secrolewwds_2_tfsecrolename), "%", "") ;
      lV60Wwpbaseobjects_secrolewwds_4_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV60Wwpbaseobjects_secrolewwds_4_tfsecroledescription), "%", "") ;
      /* Using cursor P00252 */
      pr_default.execute(0, new Object[] {lV57Wwpbaseobjects_secrolewwds_1_filterfulltext, lV57Wwpbaseobjects_secrolewwds_1_filterfulltext, lV58Wwpbaseobjects_secrolewwds_2_tfsecrolename, AV59Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel, lV60Wwpbaseobjects_secrolewwds_4_tfsecroledescription, AV61Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A12SecRoleDescription = P00252_A12SecRoleDescription[0] ;
         A13SecRoleName = P00252_A13SecRoleName[0] ;
         A4SecRoleId = P00252_A4SecRoleId[0] ;
         AV13CellRow = (int)(AV13CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S162 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A13SecRoleName, GXv_char7) ;
         secrolewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+0, 1, 1).setText( GXt_char6 );
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A12SecRoleDescription, GXv_char7) ;
         secrolewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S181( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV10ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV10ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV10ExcelDocument.getErrCode() != 0 )
      {
         AV11Filename = "" ;
         AV12ErrorMessage = AV10ExcelDocument.getErrDescription() ;
         AV10ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S191( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV41Session.getValue("WWPBaseObjects.SecRoleWWGridState"), "") == 0 )
      {
         AV33GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecRoleWWGridState"), null, null);
      }
      else
      {
         AV33GridState.fromxml(AV41Session.getValue("WWPBaseObjects.SecRoleWWGridState"), null, null);
      }
      AV16OrderedBy = AV33GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV17OrderedDsc = AV33GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV62GXV1 = 1 ;
      while ( AV62GXV1 <= AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV51GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV62GXV1));
         if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV52FilterFullText = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLENAME") == 0 )
         {
            AV35TFSecRoleName = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLENAME_SEL") == 0 )
         {
            AV36TFSecRoleName_Sel = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION") == 0 )
         {
            AV37TFSecRoleDescription = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION_SEL") == 0 )
         {
            AV38TFSecRoleDescription_Sel = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV62GXV1 = (int)(AV62GXV1+1) ;
      }
   }

   public void S162( )
   {
      /* 'BEFOREWRITELINE' Routine */
      returnInSub = false ;
   }

   public void S172( )
   {
      /* 'AFTERWRITELINE' Routine */
      returnInSub = false ;
   }

   protected void cleanup( )
   {
      this.aP0[0] = secrolewwexport.this.AV11Filename;
      this.aP1[0] = secrolewwexport.this.AV12ErrorMessage;
      CloseOpenCursors();
      AV10ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Filename = "" ;
      AV12ErrorMessage = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV55Pgmname = "" ;
      AV50WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV10ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV52FilterFullText = "" ;
      AV36TFSecRoleName_Sel = "" ;
      AV35TFSecRoleName = "" ;
      AV38TFSecRoleDescription_Sel = "" ;
      AV37TFSecRoleDescription = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      A13SecRoleName = "" ;
      A12SecRoleDescription = "" ;
      AV57Wwpbaseobjects_secrolewwds_1_filterfulltext = "" ;
      AV58Wwpbaseobjects_secrolewwds_2_tfsecrolename = "" ;
      AV59Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel = "" ;
      AV60Wwpbaseobjects_secrolewwds_4_tfsecroledescription = "" ;
      AV61Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel = "" ;
      scmdbuf = "" ;
      lV57Wwpbaseobjects_secrolewwds_1_filterfulltext = "" ;
      lV58Wwpbaseobjects_secrolewwds_2_tfsecrolename = "" ;
      lV60Wwpbaseobjects_secrolewwds_4_tfsecroledescription = "" ;
      P00252_A12SecRoleDescription = new String[] {""} ;
      P00252_A13SecRoleName = new String[] {""} ;
      P00252_A4SecRoleId = new short[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV41Session = httpContext.getWebSession();
      AV33GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV51GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secrolewwexport__default(),
         new Object[] {
             new Object[] {
            P00252_A12SecRoleDescription, P00252_A13SecRoleName, P00252_A4SecRoleId
            }
         }
      );
      AV55Pgmname = "WWPBaseObjects.SecRoleWWExport" ;
      /* GeneXus formulas. */
      AV55Pgmname = "WWPBaseObjects.SecRoleWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short GXv_int5[] ;
   private short AV16OrderedBy ;
   private short A4SecRoleId ;
   private short Gx_err ;
   private int AV13CellRow ;
   private int AV14FirstColumn ;
   private int AV15Random ;
   private int AV62GXV1 ;
   private String AV55Pgmname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV17OrderedDsc ;
   private String AV11Filename ;
   private String AV12ErrorMessage ;
   private String AV52FilterFullText ;
   private String AV36TFSecRoleName_Sel ;
   private String AV35TFSecRoleName ;
   private String AV38TFSecRoleDescription_Sel ;
   private String AV37TFSecRoleDescription ;
   private String A13SecRoleName ;
   private String A12SecRoleDescription ;
   private String AV57Wwpbaseobjects_secrolewwds_1_filterfulltext ;
   private String AV58Wwpbaseobjects_secrolewwds_2_tfsecrolename ;
   private String AV59Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel ;
   private String AV60Wwpbaseobjects_secrolewwds_4_tfsecroledescription ;
   private String AV61Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel ;
   private String lV57Wwpbaseobjects_secrolewwds_1_filterfulltext ;
   private String lV58Wwpbaseobjects_secrolewwds_2_tfsecrolename ;
   private String lV60Wwpbaseobjects_secrolewwds_4_tfsecroledescription ;
   private com.genexus.webpanels.WebSession AV41Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P00252_A12SecRoleDescription ;
   private String[] P00252_A13SecRoleName ;
   private short[] P00252_A4SecRoleId ;
   private com.genexus.gxoffice.ExcelDoc AV10ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV33GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV51GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV50WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
}

final  class secrolewwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00252( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV57Wwpbaseobjects_secrolewwds_1_filterfulltext ,
                                          String AV59Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel ,
                                          String AV58Wwpbaseobjects_secrolewwds_2_tfsecrolename ,
                                          String AV61Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel ,
                                          String AV60Wwpbaseobjects_secrolewwds_4_tfsecroledescription ,
                                          String A13SecRoleName ,
                                          String A12SecRoleDescription ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[6];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT [SecRoleDescription], [SecRoleName], [SecRoleId] FROM [SecRole]" ;
      if ( ! (GXutil.strcmp("", AV57Wwpbaseobjects_secrolewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [SecRoleName] like '%' + ?) or ( [SecRoleDescription] like '%' + ?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
         GXv_int8[1] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV59Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel)==0) && ( ! (GXutil.strcmp("", AV58Wwpbaseobjects_secrolewwds_2_tfsecrolename)==0) ) )
      {
         addWhere(sWhereString, "([SecRoleName] like ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV59Wwpbaseobjects_secrolewwds_3_tfsecrolename_sel)==0) )
      {
         addWhere(sWhereString, "([SecRoleName] = ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV61Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel)==0) && ( ! (GXutil.strcmp("", AV60Wwpbaseobjects_secrolewwds_4_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "([SecRoleDescription] like ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV61Wwpbaseobjects_secrolewwds_5_tfsecroledescription_sel)==0) )
      {
         addWhere(sWhereString, "([SecRoleDescription] = ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV16OrderedBy == 1 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY [SecRoleName]" ;
      }
      else if ( ( AV16OrderedBy == 1 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SecRoleName] DESC" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY [SecRoleDescription]" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SecRoleDescription] DESC" ;
      }
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P00252(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Boolean) dynConstraints[8]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00252", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 120);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 120);
               }
               return;
      }
   }

}

