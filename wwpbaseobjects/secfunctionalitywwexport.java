package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secfunctionalitywwexport extends GXProcedure
{
   public secfunctionalitywwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionalitywwexport.class ), "" );
   }

   public secfunctionalitywwexport( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      secfunctionalitywwexport.this.aP1 = new String[] {""};
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
      secfunctionalitywwexport.this.aP0 = aP0;
      secfunctionalitywwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecFunctionality", GXv_boolean2) ;
      secfunctionalitywwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV50Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV39WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV39WWPContext = GXv_SdtWWPContext3[0] ;
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
      AV15Random = (int)(GXutil.random( )*10000) ;
      AV11Filename = "SecFunctionalityWWExport-" + GXutil.trim( GXutil.str( AV15Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (GXutil.strcmp("", AV47FilterFullText)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Filter") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalitywwexport.this.AV13CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47FilterFullText, GXv_char7) ;
         secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (GXutil.strcmp("", AV22TFSecFunctionalityKey_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Key") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalitywwexport.this.AV13CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV22TFSecFunctionalityKey_Sel, GXv_char7) ;
         secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV21TFSecFunctionalityKey)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Key") ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secfunctionalitywwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV21TFSecFunctionalityKey, GXv_char7) ;
            secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV24TFSecFunctionalityDescription_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Description") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalitywwexport.this.AV13CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV24TFSecFunctionalityDescription_Sel, GXv_char7) ;
         secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV23TFSecFunctionalityDescription)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Description") ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secfunctionalitywwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV23TFSecFunctionalityDescription, GXv_char7) ;
            secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV44TFSecFunctionalityType_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Type") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalitywwexport.this.AV13CellRow = GXv_int5[0] ;
         AV35i = 1 ;
         AV51GXV1 = 1 ;
         while ( AV51GXV1 <= AV44TFSecFunctionalityType_Sels.size() )
         {
            AV25TFSecFunctionalityType_Sel = ((Number) AV44TFSecFunctionalityType_Sels.elementAt(-1+AV51GXV1)).byteValue() ;
            if ( AV35i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainwwpsecfunctionalitytypes.getDescription(httpContext,(byte)AV25TFSecFunctionalityType_Sel) );
            AV35i = (long)(AV35i+1) ;
            AV51GXV1 = (int)(AV51GXV1+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV27TFSecParentFunctionalityDescription_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Parent Functionality") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalitywwexport.this.AV13CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV27TFSecParentFunctionalityDescription_Sel, GXv_char7) ;
         secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV26TFSecParentFunctionalityDescription)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Parent Functionality") ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secfunctionalitywwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV26TFSecParentFunctionalityDescription, GXv_char7) ;
            secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV13CellRow = (int)(AV13CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV36VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV30Session.getValue("WWPBaseObjects.SecFunctionalityWWColumnsSelector"), "") != 0 )
      {
         AV29ColumnsSelectorXML = AV30Session.getValue("WWPBaseObjects.SecFunctionalityWWColumnsSelector") ;
         AV28ColumnsSelector.fromxml(AV29ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV52GXV2 = 1 ;
      while ( AV52GXV2 <= AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV46ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV52GXV2));
         if ( AV46ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV36VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV46ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV46ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV46ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV36VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV36VisibleColumnCount), 1, 1).setColor( 11 );
            AV36VisibleColumnCount = (long)(AV36VisibleColumnCount+1) ;
         }
         AV52GXV2 = (int)(AV52GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = AV47FilterFullText ;
      AV55Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = AV21TFSecFunctionalityKey ;
      AV56Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = AV22TFSecFunctionalityKey_Sel ;
      AV57Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = AV23TFSecFunctionalityDescription ;
      AV58Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = AV24TFSecFunctionalityDescription_Sel ;
      AV59Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = AV44TFSecFunctionalityType_Sels ;
      AV60Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = AV26TFSecParentFunctionalityDescription ;
      AV61Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = AV27TFSecParentFunctionalityDescription_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Byte.valueOf(A9SecFunctionalityType) ,
                                           AV59Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ,
                                           AV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ,
                                           AV56Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ,
                                           AV55Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ,
                                           AV58Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ,
                                           AV57Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ,
                                           Integer.valueOf(AV59Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels.size()) ,
                                           AV61Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ,
                                           AV60Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ,
                                           A3SecFunctionalityKey ,
                                           A8SecFunctionalityDescription ,
                                           A11SecParentFunctionalityDescription ,
                                           Short.valueOf(AV16OrderedBy) ,
                                           Boolean.valueOf(AV17OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext), "%", "") ;
      lV55Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV55Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey), "%", "") ;
      lV57Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV57Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription), "%", "") ;
      lV60Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV60Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription), "%", "") ;
      /* Using cursor P001Y2 */
      pr_default.execute(0, new Object[] {lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext, lV55Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey, AV56Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel, lV57Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription, AV58Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel, lV60Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription, AV61Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2SecParentFunctionalityId = P001Y2_A2SecParentFunctionalityId[0] ;
         n2SecParentFunctionalityId = P001Y2_n2SecParentFunctionalityId[0] ;
         A11SecParentFunctionalityDescription = P001Y2_A11SecParentFunctionalityDescription[0] ;
         A9SecFunctionalityType = P001Y2_A9SecFunctionalityType[0] ;
         A8SecFunctionalityDescription = P001Y2_A8SecFunctionalityDescription[0] ;
         A3SecFunctionalityKey = P001Y2_A3SecFunctionalityKey[0] ;
         A1SecFunctionalityId = P001Y2_A1SecFunctionalityId[0] ;
         A11SecParentFunctionalityDescription = P001Y2_A11SecParentFunctionalityDescription[0] ;
         AV13CellRow = (int)(AV13CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV36VisibleColumnCount = 0 ;
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A3SecFunctionalityKey, GXv_char7) ;
            secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV36VisibleColumnCount = (long)(AV36VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A8SecFunctionalityDescription, GXv_char7) ;
            secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV36VisibleColumnCount = (long)(AV36VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV36VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainwwpsecfunctionalitytypes.getDescription(httpContext,(byte)A9SecFunctionalityType) );
            AV36VisibleColumnCount = (long)(AV36VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A11SecParentFunctionalityDescription, GXv_char7) ;
            secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV36VisibleColumnCount = (long)(AV36VisibleColumnCount+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
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

   public void S151( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV28ColumnsSelector = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector)new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecFunctionalityKey", "", "Key", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecFunctionalityDescription", "", "Description", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecFunctionalityType", "", "Type", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV28ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecParentFunctionalityDescription", "", "Parent Functionality", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV31UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "WWPBaseObjects.SecFunctionalityWWColumnsSelector", GXv_char7) ;
      secfunctionalitywwexport.this.GXt_char6 = GXv_char7[0] ;
      AV31UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV31UserCustomValue)==0) ) )
      {
         AV45ColumnsSelectorAux.fromxml(AV31UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV45ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
         new com.projectthani.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV45ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV30Session.getValue("WWPBaseObjects.SecFunctionalityWWGridState"), "") == 0 )
      {
         AV41GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecFunctionalityWWGridState"), null, null);
      }
      else
      {
         AV41GridState.fromxml(AV30Session.getValue("WWPBaseObjects.SecFunctionalityWWGridState"), null, null);
      }
      AV16OrderedBy = AV41GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV17OrderedDsc = AV41GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV62GXV3 = 1 ;
      while ( AV62GXV3 <= AV41GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV42GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV41GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV62GXV3));
         if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV47FilterFullText = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY") == 0 )
         {
            AV21TFSecFunctionalityKey = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY_SEL") == 0 )
         {
            AV22TFSecFunctionalityKey_Sel = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV23TFSecFunctionalityDescription = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV24TFSecFunctionalityDescription_Sel = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYTYPE_SEL") == 0 )
         {
            AV43TFSecFunctionalityType_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFSecFunctionalityType_Sels.fromJSonString(AV43TFSecFunctionalityType_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV26TFSecParentFunctionalityDescription = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV27TFSecParentFunctionalityDescription_Sel = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV62GXV3 = (int)(AV62GXV3+1) ;
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
      this.aP0[0] = secfunctionalitywwexport.this.AV11Filename;
      this.aP1[0] = secfunctionalitywwexport.this.AV12ErrorMessage;
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
      AV50Pgmname = "" ;
      AV39WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV10ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV47FilterFullText = "" ;
      AV22TFSecFunctionalityKey_Sel = "" ;
      AV21TFSecFunctionalityKey = "" ;
      AV24TFSecFunctionalityDescription_Sel = "" ;
      AV23TFSecFunctionalityDescription = "" ;
      AV44TFSecFunctionalityType_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV27TFSecParentFunctionalityDescription_Sel = "" ;
      AV26TFSecParentFunctionalityDescription = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV30Session = httpContext.getWebSession();
      AV29ColumnsSelectorXML = "" ;
      AV28ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV46ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A3SecFunctionalityKey = "" ;
      A8SecFunctionalityDescription = "" ;
      A11SecParentFunctionalityDescription = "" ;
      AV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = "" ;
      AV55Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = "" ;
      AV56Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel = "" ;
      AV57Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = "" ;
      AV58Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel = "" ;
      AV59Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV60Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = "" ;
      AV61Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel = "" ;
      scmdbuf = "" ;
      lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext = "" ;
      lV55Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey = "" ;
      lV57Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription = "" ;
      lV60Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription = "" ;
      P001Y2_A2SecParentFunctionalityId = new long[1] ;
      P001Y2_n2SecParentFunctionalityId = new boolean[] {false} ;
      P001Y2_A11SecParentFunctionalityDescription = new String[] {""} ;
      P001Y2_A9SecFunctionalityType = new byte[1] ;
      P001Y2_A8SecFunctionalityDescription = new String[] {""} ;
      P001Y2_A3SecFunctionalityKey = new String[] {""} ;
      P001Y2_A1SecFunctionalityId = new long[1] ;
      AV31UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV45ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV41GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV42GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV43TFSecFunctionalityType_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secfunctionalitywwexport__default(),
         new Object[] {
             new Object[] {
            P001Y2_A2SecParentFunctionalityId, P001Y2_n2SecParentFunctionalityId, P001Y2_A11SecParentFunctionalityDescription, P001Y2_A9SecFunctionalityType, P001Y2_A8SecFunctionalityDescription, P001Y2_A3SecFunctionalityKey, P001Y2_A1SecFunctionalityId
            }
         }
      );
      AV50Pgmname = "WWPBaseObjects.SecFunctionalityWWExport" ;
      /* GeneXus formulas. */
      AV50Pgmname = "WWPBaseObjects.SecFunctionalityWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV25TFSecFunctionalityType_Sel ;
   private byte A9SecFunctionalityType ;
   private short GXv_int5[] ;
   private short AV16OrderedBy ;
   private short Gx_err ;
   private int AV13CellRow ;
   private int AV14FirstColumn ;
   private int AV15Random ;
   private int AV51GXV1 ;
   private int AV52GXV2 ;
   private int AV59Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size ;
   private int AV62GXV3 ;
   private long AV35i ;
   private long AV36VisibleColumnCount ;
   private long A2SecParentFunctionalityId ;
   private long A1SecFunctionalityId ;
   private String AV50Pgmname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV17OrderedDsc ;
   private boolean n2SecParentFunctionalityId ;
   private String AV29ColumnsSelectorXML ;
   private String AV31UserCustomValue ;
   private String AV43TFSecFunctionalityType_SelsJson ;
   private String AV11Filename ;
   private String AV12ErrorMessage ;
   private String AV47FilterFullText ;
   private String AV22TFSecFunctionalityKey_Sel ;
   private String AV21TFSecFunctionalityKey ;
   private String AV24TFSecFunctionalityDescription_Sel ;
   private String AV23TFSecFunctionalityDescription ;
   private String AV27TFSecParentFunctionalityDescription_Sel ;
   private String AV26TFSecParentFunctionalityDescription ;
   private String A3SecFunctionalityKey ;
   private String A8SecFunctionalityDescription ;
   private String A11SecParentFunctionalityDescription ;
   private String AV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ;
   private String AV55Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ;
   private String AV56Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ;
   private String AV57Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ;
   private String AV58Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ;
   private String AV60Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ;
   private String AV61Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ;
   private String lV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ;
   private String lV55Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ;
   private String lV57Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ;
   private String lV60Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ;
   private GXSimpleCollection<Byte> AV44TFSecFunctionalityType_Sels ;
   private GXSimpleCollection<Byte> AV59Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ;
   private com.genexus.webpanels.WebSession AV30Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P001Y2_A2SecParentFunctionalityId ;
   private boolean[] P001Y2_n2SecParentFunctionalityId ;
   private String[] P001Y2_A11SecParentFunctionalityDescription ;
   private byte[] P001Y2_A9SecFunctionalityType ;
   private String[] P001Y2_A8SecFunctionalityDescription ;
   private String[] P001Y2_A3SecFunctionalityKey ;
   private long[] P001Y2_A1SecFunctionalityId ;
   private com.genexus.gxoffice.ExcelDoc AV10ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV28ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV45ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column AV46ColumnsSelector_Column ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV39WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV41GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV42GridStateFilterValue ;
}

final  class secfunctionalitywwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P001Y2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A9SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV59Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels ,
                                          String AV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext ,
                                          String AV56Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel ,
                                          String AV55Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey ,
                                          String AV58Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel ,
                                          String AV57Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription ,
                                          int AV59Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size ,
                                          String AV61Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel ,
                                          String AV60Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription ,
                                          String A3SecFunctionalityKey ,
                                          String A8SecFunctionalityDescription ,
                                          String A11SecParentFunctionalityDescription ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[14];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.[SecParentFunctionalityId] AS SecParentFunctionalityId, T2.[SecFunctionalityDescription] AS SecParentFunctionalityDescription, T1.[SecFunctionalityType]," ;
      scmdbuf += " T1.[SecFunctionalityDescription], T1.[SecFunctionalityKey], T1.[SecFunctionalityId] FROM ([SecFunctionality] T1 LEFT JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId]" ;
      scmdbuf += " = T1.[SecParentFunctionalityId])" ;
      if ( ! (GXutil.strcmp("", AV54Wwpbaseobjects_secfunctionalitywwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[SecFunctionalityKey] like '%' + ?) or ( T1.[SecFunctionalityDescription] like '%' + ?) or ( 'mode' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 1) or ( 'action' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 2) or ( 'tab' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 3) or ( 'object' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 4) or ( 'attribute' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 5) or ( T2.[SecFunctionalityDescription] like '%' + ?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
         GXv_int10[1] = (byte)(1) ;
         GXv_int10[2] = (byte)(1) ;
         GXv_int10[3] = (byte)(1) ;
         GXv_int10[4] = (byte)(1) ;
         GXv_int10[5] = (byte)(1) ;
         GXv_int10[6] = (byte)(1) ;
         GXv_int10[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV56Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel)==0) && ( ! (GXutil.strcmp("", AV55Wwpbaseobjects_secfunctionalitywwds_2_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] like ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV56Wwpbaseobjects_secfunctionalitywwds_3_tfsecfunctionalitykey_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] = ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV58Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV57Wwpbaseobjects_secfunctionalitywwds_4_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV58Wwpbaseobjects_secfunctionalitywwds_5_tfsecfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( AV59Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV59Wwpbaseobjects_secfunctionalitywwds_6_tfsecfunctionalitytype_sels, "T1.[SecFunctionalityType] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV61Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV60Wwpbaseobjects_secfunctionalitywwds_7_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV61Wwpbaseobjects_secfunctionalitywwds_8_tfsecparentfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV16OrderedBy == 1 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecFunctionalityDescription]" ;
      }
      else if ( ( AV16OrderedBy == 1 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecFunctionalityDescription] DESC" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecFunctionalityKey]" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecFunctionalityKey] DESC" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecFunctionalityType]" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecFunctionalityType] DESC" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[SecFunctionalityDescription]" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[SecFunctionalityDescription] DESC" ;
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
                  return conditional_P001Y2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , ((Boolean) dynConstraints[14]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001Y2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
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
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               return;
      }
   }

}

