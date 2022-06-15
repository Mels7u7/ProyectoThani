package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secfunctionalityfilterparentwwexport extends GXProcedure
{
   public secfunctionalityfilterparentwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionalityfilterparentwwexport.class ), "" );
   }

   public secfunctionalityfilterparentwwexport( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      secfunctionalityfilterparentwwexport.this.aP1 = new String[] {""};
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
      secfunctionalityfilterparentwwexport.this.aP0 = aP0;
      secfunctionalityfilterparentwwexport.this.aP1 = aP1;
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
      secfunctionalityfilterparentwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV51Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV40WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV40WWPContext = GXv_SdtWWPContext3[0] ;
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
      AV11Filename = "SecFunctionalityFilterParentWWExport-" + GXutil.trim( GXutil.str( AV15Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (GXutil.strcmp("", AV48FilterFullText)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Filter") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalityfilterparentwwexport.this.AV13CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48FilterFullText, GXv_char7) ;
         secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV19SecFunctionalityType) ) )
      {
         if ( ! (0==AV19SecFunctionalityType) )
         {
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+0, 1, 1).setText( com.projectthani.gxdomainwwpsecfunctionalitytypes.getDescription(httpContext,(byte)AV19SecFunctionalityType) );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV21SecFunctionalityDescription)==0) ) )
      {
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV21SecFunctionalityDescription, GXv_char7) ;
         secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+0, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (GXutil.strcmp("", AV23TFSecFunctionalityKey_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Key") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalityfilterparentwwexport.this.AV13CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV23TFSecFunctionalityKey_Sel, GXv_char7) ;
         secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV22TFSecFunctionalityKey)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Key") ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secfunctionalityfilterparentwwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV22TFSecFunctionalityKey, GXv_char7) ;
            secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV25TFSecFunctionalityDescription_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Description") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalityfilterparentwwexport.this.AV13CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV25TFSecFunctionalityDescription_Sel, GXv_char7) ;
         secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV24TFSecFunctionalityDescription)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Description") ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secfunctionalityfilterparentwwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV24TFSecFunctionalityDescription, GXv_char7) ;
            secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV45TFSecFunctionalityType_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Type") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalityfilterparentwwexport.this.AV13CellRow = GXv_int5[0] ;
         AV36i = 1 ;
         AV52GXV1 = 1 ;
         while ( AV52GXV1 <= AV45TFSecFunctionalityType_Sels.size() )
         {
            AV26TFSecFunctionalityType_Sel = ((Number) AV45TFSecFunctionalityType_Sels.elementAt(-1+AV52GXV1)).byteValue() ;
            if ( AV36i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainwwpsecfunctionalitytypes.getDescription(httpContext,(byte)AV26TFSecFunctionalityType_Sel) );
            AV36i = (long)(AV36i+1) ;
            AV52GXV1 = (int)(AV52GXV1+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV28TFSecParentFunctionalityDescription_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Parent Functionality") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secfunctionalityfilterparentwwexport.this.AV13CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV28TFSecParentFunctionalityDescription_Sel, GXv_char7) ;
         secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV27TFSecParentFunctionalityDescription)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Parent Functionality") ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secfunctionalityfilterparentwwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV27TFSecParentFunctionalityDescription, GXv_char7) ;
            secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV13CellRow = (int)(AV13CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV37VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV31Session.getValue("WWPBaseObjects.SecFunctionalityFilterParentWWColumnsSelector"), "") != 0 )
      {
         AV30ColumnsSelectorXML = AV31Session.getValue("WWPBaseObjects.SecFunctionalityFilterParentWWColumnsSelector") ;
         AV29ColumnsSelector.fromxml(AV30ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV53GXV2 = 1 ;
      while ( AV53GXV2 <= AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV47ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV53GXV2));
         if ( AV47ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV37VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV47ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV47ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV47ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV37VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV37VisibleColumnCount), 1, 1).setColor( 11 );
            AV37VisibleColumnCount = (long)(AV37VisibleColumnCount+1) ;
         }
         AV53GXV2 = (int)(AV53GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid = AV16SecParentFunctionalityId ;
      AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = AV48FilterFullText ;
      AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_3_secfunctionalitytype = AV19SecFunctionalityType ;
      AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription = AV21SecFunctionalityDescription ;
      AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey = AV22TFSecFunctionalityKey ;
      AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel = AV23TFSecFunctionalityKey_Sel ;
      AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription = AV24TFSecFunctionalityDescription ;
      AV62Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel = AV25TFSecFunctionalityDescription_Sel ;
      AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels = AV45TFSecFunctionalityType_Sels ;
      AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription = AV27TFSecParentFunctionalityDescription ;
      AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel = AV28TFSecParentFunctionalityDescription_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Byte.valueOf(A9SecFunctionalityType) ,
                                           AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels ,
                                           AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext ,
                                           Byte.valueOf(AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_3_secfunctionalitytype) ,
                                           Short.valueOf(AV20SecFunctionalityDescriptionOperator) ,
                                           AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription ,
                                           AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel ,
                                           AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey ,
                                           AV62Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel ,
                                           AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription ,
                                           Integer.valueOf(AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels.size()) ,
                                           AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel ,
                                           AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription ,
                                           A3SecFunctionalityKey ,
                                           A8SecFunctionalityDescription ,
                                           A11SecParentFunctionalityDescription ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) ,
                                           Long.valueOf(AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid) ,
                                           Long.valueOf(A2SecParentFunctionalityId) } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.BOOLEAN
                                           }
      });
      lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = GXutil.concat( GXutil.rtrim( AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext), "%", "") ;
      lV58Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription), "%", "") ;
      lV58Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription), "%", "") ;
      lV59Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey = GXutil.concat( GXutil.rtrim( AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey), "%", "") ;
      lV61Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription), "%", "") ;
      lV64Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription = GXutil.concat( GXutil.rtrim( AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription), "%", "") ;
      /* Using cursor P001T2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid), lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext, Byte.valueOf(AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_3_secfunctionalitytype), lV58Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription, lV58Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription, lV59Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey, AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel, lV61Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription, AV62Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel, lV64Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription, AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A11SecParentFunctionalityDescription = P001T2_A11SecParentFunctionalityDescription[0] ;
         A9SecFunctionalityType = P001T2_A9SecFunctionalityType[0] ;
         A8SecFunctionalityDescription = P001T2_A8SecFunctionalityDescription[0] ;
         A3SecFunctionalityKey = P001T2_A3SecFunctionalityKey[0] ;
         A2SecParentFunctionalityId = P001T2_A2SecParentFunctionalityId[0] ;
         n2SecParentFunctionalityId = P001T2_n2SecParentFunctionalityId[0] ;
         A1SecFunctionalityId = P001T2_A1SecFunctionalityId[0] ;
         A11SecParentFunctionalityDescription = P001T2_A11SecParentFunctionalityDescription[0] ;
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
         AV37VisibleColumnCount = 0 ;
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A3SecFunctionalityKey, GXv_char7) ;
            secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV37VisibleColumnCount = (long)(AV37VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A8SecFunctionalityDescription, GXv_char7) ;
            secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV37VisibleColumnCount = (long)(AV37VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV37VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainwwpsecfunctionalitytypes.getDescription(httpContext,(byte)A9SecFunctionalityType) );
            AV37VisibleColumnCount = (long)(AV37VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A11SecParentFunctionalityDescription, GXv_char7) ;
            secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV37VisibleColumnCount = (long)(AV37VisibleColumnCount+1) ;
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
      AV29ColumnsSelector = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector)new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecFunctionalityKey", "", "Key", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecFunctionalityDescription", "", "Description", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecFunctionalityType", "", "Type", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecParentFunctionalityDescription", "", "Parent Functionality", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV32UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "WWPBaseObjects.SecFunctionalityFilterParentWWColumnsSelector", GXv_char7) ;
      secfunctionalityfilterparentwwexport.this.GXt_char6 = GXv_char7[0] ;
      AV32UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV32UserCustomValue)==0) ) )
      {
         AV46ColumnsSelectorAux.fromxml(AV32UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV46ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
         new com.projectthani.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV46ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV31Session.getValue("WWPBaseObjects.SecFunctionalityFilterParentWWGridState"), "") == 0 )
      {
         AV42GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecFunctionalityFilterParentWWGridState"), null, null);
      }
      else
      {
         AV42GridState.fromxml(AV31Session.getValue("WWPBaseObjects.SecFunctionalityFilterParentWWGridState"), null, null);
      }
      AV17OrderedBy = AV42GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV42GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV66GXV3 = 1 ;
      while ( AV66GXV3 <= AV42GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV43GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV42GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV66GXV3));
         if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV48FilterFullText = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "SECFUNCTIONALITYTYPE") == 0 )
         {
            AV19SecFunctionalityType = (byte)(GXutil.lval( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "SECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV21SecFunctionalityDescription = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV20SecFunctionalityDescriptionOperator = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Operator() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY") == 0 )
         {
            AV22TFSecFunctionalityKey = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYKEY_SEL") == 0 )
         {
            AV23TFSecFunctionalityKey_Sel = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV24TFSecFunctionalityDescription = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV25TFSecFunctionalityDescription_Sel = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECFUNCTIONALITYTYPE_SEL") == 0 )
         {
            AV44TFSecFunctionalityType_SelsJson = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFSecFunctionalityType_Sels.fromJSonString(AV44TFSecFunctionalityType_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION") == 0 )
         {
            AV27TFSecParentFunctionalityDescription = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECPARENTFUNCTIONALITYDESCRIPTION_SEL") == 0 )
         {
            AV28TFSecParentFunctionalityDescription_Sel = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&SECPARENTFUNCTIONALITYID") == 0 )
         {
            AV16SecParentFunctionalityId = GXutil.lval( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
         }
         AV66GXV3 = (int)(AV66GXV3+1) ;
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
      this.aP0[0] = secfunctionalityfilterparentwwexport.this.AV11Filename;
      this.aP1[0] = secfunctionalityfilterparentwwexport.this.AV12ErrorMessage;
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
      AV51Pgmname = "" ;
      AV40WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV10ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV48FilterFullText = "" ;
      AV21SecFunctionalityDescription = "" ;
      AV23TFSecFunctionalityKey_Sel = "" ;
      AV22TFSecFunctionalityKey = "" ;
      AV25TFSecFunctionalityDescription_Sel = "" ;
      AV24TFSecFunctionalityDescription = "" ;
      AV45TFSecFunctionalityType_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV28TFSecParentFunctionalityDescription_Sel = "" ;
      AV27TFSecParentFunctionalityDescription = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV31Session = httpContext.getWebSession();
      AV30ColumnsSelectorXML = "" ;
      AV29ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV47ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A3SecFunctionalityKey = "" ;
      A8SecFunctionalityDescription = "" ;
      A11SecParentFunctionalityDescription = "" ;
      AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = "" ;
      AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription = "" ;
      AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey = "" ;
      AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel = "" ;
      AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription = "" ;
      AV62Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel = "" ;
      AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription = "" ;
      AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel = "" ;
      scmdbuf = "" ;
      lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext = "" ;
      lV58Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription = "" ;
      lV59Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey = "" ;
      lV61Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription = "" ;
      lV64Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription = "" ;
      P001T2_A11SecParentFunctionalityDescription = new String[] {""} ;
      P001T2_A9SecFunctionalityType = new byte[1] ;
      P001T2_A8SecFunctionalityDescription = new String[] {""} ;
      P001T2_A3SecFunctionalityKey = new String[] {""} ;
      P001T2_A2SecParentFunctionalityId = new long[1] ;
      P001T2_n2SecParentFunctionalityId = new boolean[] {false} ;
      P001T2_A1SecFunctionalityId = new long[1] ;
      AV32UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV46ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV42GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV43GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV44TFSecFunctionalityType_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secfunctionalityfilterparentwwexport__default(),
         new Object[] {
             new Object[] {
            P001T2_A11SecParentFunctionalityDescription, P001T2_A9SecFunctionalityType, P001T2_A8SecFunctionalityDescription, P001T2_A3SecFunctionalityKey, P001T2_A2SecParentFunctionalityId, P001T2_n2SecParentFunctionalityId, P001T2_A1SecFunctionalityId
            }
         }
      );
      AV51Pgmname = "WWPBaseObjects.SecFunctionalityFilterParentWWExport" ;
      /* GeneXus formulas. */
      AV51Pgmname = "WWPBaseObjects.SecFunctionalityFilterParentWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV19SecFunctionalityType ;
   private byte AV26TFSecFunctionalityType_Sel ;
   private byte A9SecFunctionalityType ;
   private byte AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_3_secfunctionalitytype ;
   private short GXv_int5[] ;
   private short AV20SecFunctionalityDescriptionOperator ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV13CellRow ;
   private int AV14FirstColumn ;
   private int AV15Random ;
   private int AV52GXV1 ;
   private int AV53GXV2 ;
   private int AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels_size ;
   private int AV66GXV3 ;
   private long AV36i ;
   private long AV37VisibleColumnCount ;
   private long AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid ;
   private long AV16SecParentFunctionalityId ;
   private long A2SecParentFunctionalityId ;
   private long A1SecFunctionalityId ;
   private String AV51Pgmname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private boolean n2SecParentFunctionalityId ;
   private String AV30ColumnsSelectorXML ;
   private String AV32UserCustomValue ;
   private String AV44TFSecFunctionalityType_SelsJson ;
   private String AV11Filename ;
   private String AV12ErrorMessage ;
   private String AV48FilterFullText ;
   private String AV21SecFunctionalityDescription ;
   private String AV23TFSecFunctionalityKey_Sel ;
   private String AV22TFSecFunctionalityKey ;
   private String AV25TFSecFunctionalityDescription_Sel ;
   private String AV24TFSecFunctionalityDescription ;
   private String AV28TFSecParentFunctionalityDescription_Sel ;
   private String AV27TFSecParentFunctionalityDescription ;
   private String A3SecFunctionalityKey ;
   private String A8SecFunctionalityDescription ;
   private String A11SecParentFunctionalityDescription ;
   private String AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext ;
   private String AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription ;
   private String AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey ;
   private String AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel ;
   private String AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription ;
   private String AV62Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel ;
   private String AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription ;
   private String AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel ;
   private String lV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext ;
   private String lV58Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription ;
   private String lV59Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey ;
   private String lV61Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription ;
   private String lV64Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription ;
   private GXSimpleCollection<Byte> AV45TFSecFunctionalityType_Sels ;
   private GXSimpleCollection<Byte> AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels ;
   private com.genexus.webpanels.WebSession AV31Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P001T2_A11SecParentFunctionalityDescription ;
   private byte[] P001T2_A9SecFunctionalityType ;
   private String[] P001T2_A8SecFunctionalityDescription ;
   private String[] P001T2_A3SecFunctionalityKey ;
   private long[] P001T2_A2SecParentFunctionalityId ;
   private boolean[] P001T2_n2SecParentFunctionalityId ;
   private long[] P001T2_A1SecFunctionalityId ;
   private com.genexus.gxoffice.ExcelDoc AV10ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV29ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV46ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column AV47ColumnsSelector_Column ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV40WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV42GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV43GridStateFilterValue ;
}

final  class secfunctionalityfilterparentwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P001T2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A9SecFunctionalityType ,
                                          GXSimpleCollection<Byte> AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels ,
                                          String AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext ,
                                          byte AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_3_secfunctionalitytype ,
                                          short AV20SecFunctionalityDescriptionOperator ,
                                          String AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription ,
                                          String AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel ,
                                          String AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey ,
                                          String AV62Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel ,
                                          String AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription ,
                                          int AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels_size ,
                                          String AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel ,
                                          String AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription ,
                                          String A3SecFunctionalityKey ,
                                          String A8SecFunctionalityDescription ,
                                          String A11SecParentFunctionalityDescription ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          long AV55Wwpbaseobjects_secfunctionalityfilterparentwwds_1_secparentfunctionalityid ,
                                          long A2SecParentFunctionalityId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[18];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T2.[SecFunctionalityDescription] AS SecParentFunctionalityDescription, T1.[SecFunctionalityType], T1.[SecFunctionalityDescription], T1.[SecFunctionalityKey]," ;
      scmdbuf += " T1.[SecParentFunctionalityId] AS SecParentFunctionalityId, T1.[SecFunctionalityId] FROM ([SecFunctionality] T1 LEFT JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId]" ;
      scmdbuf += " = T1.[SecParentFunctionalityId])" ;
      addWhere(sWhereString, "(T1.[SecParentFunctionalityId] = ?)");
      if ( ! (GXutil.strcmp("", AV56Wwpbaseobjects_secfunctionalityfilterparentwwds_2_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[SecFunctionalityKey] like '%' + ?) or ( T1.[SecFunctionalityDescription] like '%' + ?) or ( 'mode' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 1) or ( 'action' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 2) or ( 'tab' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 3) or ( 'object' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 4) or ( 'attribute' like '%' + LOWER(?) and T1.[SecFunctionalityType] = 5) or ( T2.[SecFunctionalityDescription] like '%' + ?))");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
         GXv_int10[2] = (byte)(1) ;
         GXv_int10[3] = (byte)(1) ;
         GXv_int10[4] = (byte)(1) ;
         GXv_int10[5] = (byte)(1) ;
         GXv_int10[6] = (byte)(1) ;
         GXv_int10[7] = (byte)(1) ;
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (0==AV57Wwpbaseobjects_secfunctionalityfilterparentwwds_3_secfunctionalitytype) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityType] = ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ( AV20SecFunctionalityDescriptionOperator == 0 ) && ( ! (GXutil.strcmp("", AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ( AV20SecFunctionalityDescriptionOperator == 1 ) && ( ! (GXutil.strcmp("", AV58Wwpbaseobjects_secfunctionalityfilterparentwwds_4_secfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] like '%' + ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel)==0) && ( ! (GXutil.strcmp("", AV59Wwpbaseobjects_secfunctionalityfilterparentwwds_5_tfsecfunctionalitykey)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] like ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV60Wwpbaseobjects_secfunctionalityfilterparentwwds_6_tfsecfunctionalitykey_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityKey] = ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV62Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV61Wwpbaseobjects_secfunctionalityfilterparentwwds_7_tfsecfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV62Wwpbaseobjects_secfunctionalityfilterparentwwds_8_tfsecfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV63Wwpbaseobjects_secfunctionalityfilterparentwwds_9_tfsecfunctionalitytype_sels, "T1.[SecFunctionalityType] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel)==0) && ( ! (GXutil.strcmp("", AV64Wwpbaseobjects_secfunctionalityfilterparentwwds_10_tfsecparentfunctionalitydescription)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] like ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV65Wwpbaseobjects_secfunctionalityfilterparentwwds_11_tfsecparentfunctionalitydescription_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecFunctionalityDescription] = ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId], T1.[SecFunctionalityDescription]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId] DESC, T1.[SecFunctionalityDescription] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId], T1.[SecFunctionalityKey]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId] DESC, T1.[SecFunctionalityKey] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId], T1.[SecFunctionalityType]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId] DESC, T1.[SecFunctionalityType] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId], T2.[SecFunctionalityDescription]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecParentFunctionalityId] DESC, T2.[SecFunctionalityDescription] DESC" ;
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
                  return conditional_P001T2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).byteValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Boolean) dynConstraints[17]).booleanValue() , ((Number) dynConstraints[18]).longValue() , ((Number) dynConstraints[19]).longValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001T2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
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
                  stmt.setLong(sIdx, ((Number) parms[18]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               return;
      }
   }

}

