package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class configwwexport extends GXProcedure
{
   public configwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( configwwexport.class ), "" );
   }

   public configwwexport( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      configwwexport.this.aP1 = new String[] {""};
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
      configwwexport.this.aP0 = aP0;
      configwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConfig", GXv_boolean2) ;
      configwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV47Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'OPENDOCUMENT' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV14CellRow = 1 ;
         AV15FirstColumn = 1 ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S201 ();
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
         S161 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'CLOSEDOCUMENT' */
         S191 ();
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
      AV16Random = (int)(GXutil.random( )*10000) ;
      AV12Filename = "ConfigWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
      AV11ExcelDocument.Open(AV12Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( (GXutil.strcmp("", AV19FilterFullText)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Filter") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         configwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         configwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFConfigId) && (0==AV36TFConfigId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         configwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFConfigId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         configwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFConfigId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV38TFConfigKey_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Key") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         configwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFConfigKey_Sel, GXv_char7) ;
         configwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFConfigKey)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Key") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            configwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFConfigKey, GXv_char7) ;
            configwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV40TFConfigValue_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Value") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         configwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFConfigValue_Sel, GXv_char7) ;
         configwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFConfigValue)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Value") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            configwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFConfigValue, GXv_char7) ;
            configwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV42TFConfigEstadoR_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estado R") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         configwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV44i = 1 ;
         AV48GXV1 = 1 ;
         while ( AV48GXV1 <= AV42TFConfigEstadoR_Sels.size() )
         {
            AV43TFConfigEstadoR_Sel = (String)AV42TFConfigEstadoR_Sels.elementAt(-1+AV48GXV1) ;
            if ( AV44i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestador.getDescription(httpContext,(String)AV43TFConfigEstadoR_Sel) );
            AV44i = (long)(AV44i+1) ;
            AV48GXV1 = (int)(AV48GXV1+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("ConfigWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("ConfigWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV49GXV2 = 1 ;
      while ( AV49GXV2 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV49GXV2));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV49GXV2 = (int)(AV49GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV51Configwwds_1_filterfulltext = AV19FilterFullText ;
      AV52Configwwds_2_tfconfigid = AV35TFConfigId ;
      AV53Configwwds_3_tfconfigid_to = AV36TFConfigId_To ;
      AV54Configwwds_4_tfconfigkey = AV37TFConfigKey ;
      AV55Configwwds_5_tfconfigkey_sel = AV38TFConfigKey_Sel ;
      AV56Configwwds_6_tfconfigvalue = AV39TFConfigValue ;
      AV57Configwwds_7_tfconfigvalue_sel = AV40TFConfigValue_Sel ;
      AV58Configwwds_8_tfconfigestador_sels = AV42TFConfigEstadoR_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A129ConfigEstadoR ,
                                           AV58Configwwds_8_tfconfigestador_sels ,
                                           AV51Configwwds_1_filterfulltext ,
                                           Short.valueOf(AV52Configwwds_2_tfconfigid) ,
                                           Short.valueOf(AV53Configwwds_3_tfconfigid_to) ,
                                           AV55Configwwds_5_tfconfigkey_sel ,
                                           AV54Configwwds_4_tfconfigkey ,
                                           AV57Configwwds_7_tfconfigvalue_sel ,
                                           AV56Configwwds_6_tfconfigvalue ,
                                           Integer.valueOf(AV58Configwwds_8_tfconfigestador_sels.size()) ,
                                           Short.valueOf(A33ConfigId) ,
                                           A127ConfigKey ,
                                           A128ConfigValue ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV51Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV51Configwwds_1_filterfulltext), "%", "") ;
      lV51Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV51Configwwds_1_filterfulltext), "%", "") ;
      lV51Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV51Configwwds_1_filterfulltext), "%", "") ;
      lV51Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV51Configwwds_1_filterfulltext), "%", "") ;
      lV51Configwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV51Configwwds_1_filterfulltext), "%", "") ;
      lV54Configwwds_4_tfconfigkey = GXutil.concat( GXutil.rtrim( AV54Configwwds_4_tfconfigkey), "%", "") ;
      lV56Configwwds_6_tfconfigvalue = GXutil.concat( GXutil.rtrim( AV56Configwwds_6_tfconfigvalue), "%", "") ;
      /* Using cursor P00642 */
      pr_default.execute(0, new Object[] {lV51Configwwds_1_filterfulltext, lV51Configwwds_1_filterfulltext, lV51Configwwds_1_filterfulltext, lV51Configwwds_1_filterfulltext, lV51Configwwds_1_filterfulltext, Short.valueOf(AV52Configwwds_2_tfconfigid), Short.valueOf(AV53Configwwds_3_tfconfigid_to), lV54Configwwds_4_tfconfigkey, AV55Configwwds_5_tfconfigkey_sel, lV56Configwwds_6_tfconfigvalue, AV57Configwwds_7_tfconfigvalue_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A33ConfigId = P00642_A33ConfigId[0] ;
         A129ConfigEstadoR = P00642_A129ConfigEstadoR[0] ;
         A128ConfigValue = P00642_A128ConfigValue[0] ;
         A127ConfigKey = P00642_A127ConfigKey[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A33ConfigId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A127ConfigKey, GXv_char7) ;
            configwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A128ConfigValue, GXv_char7) ;
            configwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestador.getDescription(httpContext,(String)A129ConfigEstadoR) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
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

   public void S191( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV11ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV11ExcelDocument.getErrCode() != 0 )
      {
         AV12Filename = "" ;
         AV13ErrorMessage = AV11ExcelDocument.getErrDescription() ;
         AV11ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S151( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV24ColumnsSelector = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector)new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConfigId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConfigKey", "", "Key", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConfigValue", "", "Value", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ConfigEstadoR", "", "Estado R", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ConfigWWColumnsSelector", GXv_char7) ;
      configwwexport.this.GXt_char6 = GXv_char7[0] ;
      AV28UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
         new com.projectthani.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("ConfigWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ConfigWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ConfigWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV59GXV3 = 1 ;
      while ( AV59GXV3 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV59GXV3));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGID") == 0 )
         {
            AV35TFConfigId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFConfigId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGKEY") == 0 )
         {
            AV37TFConfigKey = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGKEY_SEL") == 0 )
         {
            AV38TFConfigKey_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGVALUE") == 0 )
         {
            AV39TFConfigValue = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGVALUE_SEL") == 0 )
         {
            AV40TFConfigValue_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONFIGESTADOR_SEL") == 0 )
         {
            AV41TFConfigEstadoR_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFConfigEstadoR_Sels.fromJSonString(AV41TFConfigEstadoR_SelsJson, null);
         }
         AV59GXV3 = (int)(AV59GXV3+1) ;
      }
   }

   public void S172( )
   {
      /* 'BEFOREWRITELINE' Routine */
      returnInSub = false ;
   }

   public void S182( )
   {
      /* 'AFTERWRITELINE' Routine */
      returnInSub = false ;
   }

   protected void cleanup( )
   {
      this.aP0[0] = configwwexport.this.AV12Filename;
      this.aP1[0] = configwwexport.this.AV13ErrorMessage;
      CloseOpenCursors();
      AV11ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Filename = "" ;
      AV13ErrorMessage = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV47Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV38TFConfigKey_Sel = "" ;
      AV37TFConfigKey = "" ;
      AV40TFConfigValue_Sel = "" ;
      AV39TFConfigValue = "" ;
      AV42TFConfigEstadoR_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV43TFConfigEstadoR_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A127ConfigKey = "" ;
      A128ConfigValue = "" ;
      A129ConfigEstadoR = "" ;
      AV51Configwwds_1_filterfulltext = "" ;
      AV54Configwwds_4_tfconfigkey = "" ;
      AV55Configwwds_5_tfconfigkey_sel = "" ;
      AV56Configwwds_6_tfconfigvalue = "" ;
      AV57Configwwds_7_tfconfigvalue_sel = "" ;
      AV58Configwwds_8_tfconfigestador_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV51Configwwds_1_filterfulltext = "" ;
      lV54Configwwds_4_tfconfigkey = "" ;
      lV56Configwwds_6_tfconfigvalue = "" ;
      P00642_A33ConfigId = new short[1] ;
      P00642_A129ConfigEstadoR = new String[] {""} ;
      P00642_A128ConfigValue = new String[] {""} ;
      P00642_A127ConfigKey = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV41TFConfigEstadoR_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.configwwexport__default(),
         new Object[] {
             new Object[] {
            P00642_A33ConfigId, P00642_A129ConfigEstadoR, P00642_A128ConfigValue, P00642_A127ConfigKey
            }
         }
      );
      AV47Pgmname = "ConfigWWExport" ;
      /* GeneXus formulas. */
      AV47Pgmname = "ConfigWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV35TFConfigId ;
   private short AV36TFConfigId_To ;
   private short GXv_int5[] ;
   private short A33ConfigId ;
   private short AV52Configwwds_2_tfconfigid ;
   private short AV53Configwwds_3_tfconfigid_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV48GXV1 ;
   private int AV49GXV2 ;
   private int AV58Configwwds_8_tfconfigestador_sels_size ;
   private int AV59GXV3 ;
   private long AV44i ;
   private long AV32VisibleColumnCount ;
   private String AV47Pgmname ;
   private String AV43TFConfigEstadoR_Sel ;
   private String A129ConfigEstadoR ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV41TFConfigEstadoR_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV38TFConfigKey_Sel ;
   private String AV37TFConfigKey ;
   private String AV40TFConfigValue_Sel ;
   private String AV39TFConfigValue ;
   private String A127ConfigKey ;
   private String A128ConfigValue ;
   private String AV51Configwwds_1_filterfulltext ;
   private String AV54Configwwds_4_tfconfigkey ;
   private String AV55Configwwds_5_tfconfigkey_sel ;
   private String AV56Configwwds_6_tfconfigvalue ;
   private String AV57Configwwds_7_tfconfigvalue_sel ;
   private String lV51Configwwds_1_filterfulltext ;
   private String lV54Configwwds_4_tfconfigkey ;
   private String lV56Configwwds_6_tfconfigvalue ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV42TFConfigEstadoR_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P00642_A33ConfigId ;
   private String[] P00642_A129ConfigEstadoR ;
   private String[] P00642_A128ConfigValue ;
   private String[] P00642_A127ConfigKey ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV58Configwwds_8_tfconfigestador_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class configwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00642( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A129ConfigEstadoR ,
                                          GXSimpleCollection<String> AV58Configwwds_8_tfconfigestador_sels ,
                                          String AV51Configwwds_1_filterfulltext ,
                                          short AV52Configwwds_2_tfconfigid ,
                                          short AV53Configwwds_3_tfconfigid_to ,
                                          String AV55Configwwds_5_tfconfigkey_sel ,
                                          String AV54Configwwds_4_tfconfigkey ,
                                          String AV57Configwwds_7_tfconfigvalue_sel ,
                                          String AV56Configwwds_6_tfconfigvalue ,
                                          int AV58Configwwds_8_tfconfigestador_sels_size ,
                                          short A33ConfigId ,
                                          String A127ConfigKey ,
                                          String A128ConfigValue ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[11];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [ConfigId], [ConfigEstadoR], [ConfigValue], [ConfigKey] FROM [Config]" ;
      if ( ! (GXutil.strcmp("", AV51Configwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ConfigId] AS decimal(4,0))) like '%' + ?) or ( [ConfigKey] like '%' + ?) or ( [ConfigValue] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [ConfigEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ConfigEstadoR] = 'I'))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
         GXv_int10[1] = (byte)(1) ;
         GXv_int10[2] = (byte)(1) ;
         GXv_int10[3] = (byte)(1) ;
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (0==AV52Configwwds_2_tfconfigid) )
      {
         addWhere(sWhereString, "([ConfigId] >= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV53Configwwds_3_tfconfigid_to) )
      {
         addWhere(sWhereString, "([ConfigId] <= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV55Configwwds_5_tfconfigkey_sel)==0) && ( ! (GXutil.strcmp("", AV54Configwwds_4_tfconfigkey)==0) ) )
      {
         addWhere(sWhereString, "([ConfigKey] like ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV55Configwwds_5_tfconfigkey_sel)==0) )
      {
         addWhere(sWhereString, "([ConfigKey] = ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV57Configwwds_7_tfconfigvalue_sel)==0) && ( ! (GXutil.strcmp("", AV56Configwwds_6_tfconfigvalue)==0) ) )
      {
         addWhere(sWhereString, "([ConfigValue] like ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Configwwds_7_tfconfigvalue_sel)==0) )
      {
         addWhere(sWhereString, "([ConfigValue] = ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( AV58Configwwds_8_tfconfigestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV58Configwwds_8_tfconfigestador_sels, "[ConfigEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ConfigKey]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ConfigKey] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ConfigId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ConfigId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ConfigValue]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ConfigValue] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ConfigEstadoR]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ConfigEstadoR] DESC" ;
      }
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
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
                  return conditional_P00642(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , ((Boolean) dynConstraints[14]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00642", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
                  stmt.setVarchar(sIdx, (String)parms[11], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 500);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 500);
               }
               return;
      }
   }

}

