package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class petitoriosubcategwwexport extends GXProcedure
{
   public petitoriosubcategwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( petitoriosubcategwwexport.class ), "" );
   }

   public petitoriosubcategwwexport( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      petitoriosubcategwwexport.this.aP1 = new String[] {""};
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
      petitoriosubcategwwexport.this.aP0 = aP0;
      petitoriosubcategwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorioSubCateg", GXv_boolean2) ;
      petitoriosubcategwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV46Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "PetitorioSubCategWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         petitoriosubcategwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         petitoriosubcategwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFPetitorioSubCategId) && (0==AV36TFPetitorioSubCategId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Categoría") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriosubcategwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFPetitorioSubCategId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriosubcategwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFPetitorioSubCategId_To );
      }
      if ( ! ( (0==AV37TFPetitorioCategId) && (0==AV38TFPetitorioCategId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Petitorio Categ Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriosubcategwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV37TFPetitorioCategId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriosubcategwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV38TFPetitorioCategId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV40TFPetitorioCategNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Petitorio Categ Nombre") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriosubcategwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFPetitorioCategNombre_Sel, GXv_char7) ;
         petitoriosubcategwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFPetitorioCategNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Petitorio Categ Nombre") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            petitoriosubcategwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFPetitorioCategNombre, GXv_char7) ;
            petitoriosubcategwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV42TFPetitorioSubCategNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Categ Nombre") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriosubcategwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFPetitorioSubCategNombre_Sel, GXv_char7) ;
         petitoriosubcategwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV41TFPetitorioSubCategNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Categ Nombre") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            petitoriosubcategwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFPetitorioSubCategNombre, GXv_char7) ;
            petitoriosubcategwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("PetitorioSubCategWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("PetitorioSubCategWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV47GXV1 = 1 ;
      while ( AV47GXV1 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV47GXV1));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV47GXV1 = (int)(AV47GXV1+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV49Petitoriosubcategwwds_1_filterfulltext = AV19FilterFullText ;
      AV50Petitoriosubcategwwds_2_tfpetitoriosubcategid = AV35TFPetitorioSubCategId ;
      AV51Petitoriosubcategwwds_3_tfpetitoriosubcategid_to = AV36TFPetitorioSubCategId_To ;
      AV52Petitoriosubcategwwds_4_tfpetitoriocategid = AV37TFPetitorioCategId ;
      AV53Petitoriosubcategwwds_5_tfpetitoriocategid_to = AV38TFPetitorioCategId_To ;
      AV54Petitoriosubcategwwds_6_tfpetitoriocategnombre = AV39TFPetitorioCategNombre ;
      AV55Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel = AV40TFPetitorioCategNombre_Sel ;
      AV56Petitoriosubcategwwds_8_tfpetitoriosubcategnombre = AV41TFPetitorioSubCategNombre ;
      AV57Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel = AV42TFPetitorioSubCategNombre_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV49Petitoriosubcategwwds_1_filterfulltext ,
                                           Short.valueOf(AV50Petitoriosubcategwwds_2_tfpetitoriosubcategid) ,
                                           Short.valueOf(AV51Petitoriosubcategwwds_3_tfpetitoriosubcategid_to) ,
                                           Short.valueOf(AV52Petitoriosubcategwwds_4_tfpetitoriocategid) ,
                                           Short.valueOf(AV53Petitoriosubcategwwds_5_tfpetitoriocategid_to) ,
                                           AV55Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel ,
                                           AV54Petitoriosubcategwwds_6_tfpetitoriocategnombre ,
                                           AV57Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel ,
                                           AV56Petitoriosubcategwwds_8_tfpetitoriosubcategnombre ,
                                           Short.valueOf(A48PetitorioSubCategId) ,
                                           Short.valueOf(A49PetitorioCategId) ,
                                           A266PetitorioCategNombre ,
                                           A265PetitorioSubCategNombre ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV49Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV49Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV49Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV49Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV49Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV49Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV49Petitoriosubcategwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV49Petitoriosubcategwwds_1_filterfulltext), "%", "") ;
      lV54Petitoriosubcategwwds_6_tfpetitoriocategnombre = GXutil.concat( GXutil.rtrim( AV54Petitoriosubcategwwds_6_tfpetitoriocategnombre), "%", "") ;
      lV56Petitoriosubcategwwds_8_tfpetitoriosubcategnombre = GXutil.concat( GXutil.rtrim( AV56Petitoriosubcategwwds_8_tfpetitoriosubcategnombre), "%", "") ;
      /* Using cursor P004V2 */
      pr_default.execute(0, new Object[] {lV49Petitoriosubcategwwds_1_filterfulltext, lV49Petitoriosubcategwwds_1_filterfulltext, lV49Petitoriosubcategwwds_1_filterfulltext, lV49Petitoriosubcategwwds_1_filterfulltext, Short.valueOf(AV50Petitoriosubcategwwds_2_tfpetitoriosubcategid), Short.valueOf(AV51Petitoriosubcategwwds_3_tfpetitoriosubcategid_to), Short.valueOf(AV52Petitoriosubcategwwds_4_tfpetitoriocategid), Short.valueOf(AV53Petitoriosubcategwwds_5_tfpetitoriocategid_to), lV54Petitoriosubcategwwds_6_tfpetitoriocategnombre, AV55Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel, lV56Petitoriosubcategwwds_8_tfpetitoriosubcategnombre, AV57Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A49PetitorioCategId = P004V2_A49PetitorioCategId[0] ;
         A48PetitorioSubCategId = P004V2_A48PetitorioSubCategId[0] ;
         A265PetitorioSubCategNombre = P004V2_A265PetitorioSubCategNombre[0] ;
         A266PetitorioCategNombre = P004V2_A266PetitorioCategNombre[0] ;
         A266PetitorioCategNombre = P004V2_A266PetitorioCategNombre[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A48PetitorioSubCategId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A49PetitorioCategId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A266PetitorioCategNombre, GXv_char7) ;
            petitoriosubcategwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A265PetitorioSubCategNombre, GXv_char7) ;
            petitoriosubcategwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PetitorioSubCategId", "", "Categoría", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PetitorioCategId", "", "Petitorio Categ Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PetitorioCategNombre", "", "Petitorio Categ Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PetitorioSubCategNombre", "", "Categ Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "PetitorioSubCategWWColumnsSelector", GXv_char7) ;
      petitoriosubcategwwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("PetitorioSubCategWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PetitorioSubCategWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("PetitorioSubCategWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV58GXV2 = 1 ;
      while ( AV58GXV2 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV58GXV2));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOSUBCATEGID") == 0 )
         {
            AV35TFPetitorioSubCategId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFPetitorioSubCategId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGID") == 0 )
         {
            AV37TFPetitorioCategId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV38TFPetitorioCategId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGNOMBRE") == 0 )
         {
            AV39TFPetitorioCategNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGNOMBRE_SEL") == 0 )
         {
            AV40TFPetitorioCategNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOSUBCATEGNOMBRE") == 0 )
         {
            AV41TFPetitorioSubCategNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOSUBCATEGNOMBRE_SEL") == 0 )
         {
            AV42TFPetitorioSubCategNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV58GXV2 = (int)(AV58GXV2+1) ;
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
      this.aP0[0] = petitoriosubcategwwexport.this.AV12Filename;
      this.aP1[0] = petitoriosubcategwwexport.this.AV13ErrorMessage;
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
      AV46Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV40TFPetitorioCategNombre_Sel = "" ;
      AV39TFPetitorioCategNombre = "" ;
      AV42TFPetitorioSubCategNombre_Sel = "" ;
      AV41TFPetitorioSubCategNombre = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A266PetitorioCategNombre = "" ;
      A265PetitorioSubCategNombre = "" ;
      AV49Petitoriosubcategwwds_1_filterfulltext = "" ;
      AV54Petitoriosubcategwwds_6_tfpetitoriocategnombre = "" ;
      AV55Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel = "" ;
      AV56Petitoriosubcategwwds_8_tfpetitoriosubcategnombre = "" ;
      AV57Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel = "" ;
      scmdbuf = "" ;
      lV49Petitoriosubcategwwds_1_filterfulltext = "" ;
      lV54Petitoriosubcategwwds_6_tfpetitoriocategnombre = "" ;
      lV56Petitoriosubcategwwds_8_tfpetitoriosubcategnombre = "" ;
      P004V2_A49PetitorioCategId = new short[1] ;
      P004V2_A48PetitorioSubCategId = new short[1] ;
      P004V2_A265PetitorioSubCategNombre = new String[] {""} ;
      P004V2_A266PetitorioCategNombre = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.petitoriosubcategwwexport__default(),
         new Object[] {
             new Object[] {
            P004V2_A49PetitorioCategId, P004V2_A48PetitorioSubCategId, P004V2_A265PetitorioSubCategNombre, P004V2_A266PetitorioCategNombre
            }
         }
      );
      AV46Pgmname = "PetitorioSubCategWWExport" ;
      /* GeneXus formulas. */
      AV46Pgmname = "PetitorioSubCategWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV35TFPetitorioSubCategId ;
   private short AV36TFPetitorioSubCategId_To ;
   private short AV37TFPetitorioCategId ;
   private short AV38TFPetitorioCategId_To ;
   private short GXv_int5[] ;
   private short A48PetitorioSubCategId ;
   private short A49PetitorioCategId ;
   private short AV50Petitoriosubcategwwds_2_tfpetitoriosubcategid ;
   private short AV51Petitoriosubcategwwds_3_tfpetitoriosubcategid_to ;
   private short AV52Petitoriosubcategwwds_4_tfpetitoriocategid ;
   private short AV53Petitoriosubcategwwds_5_tfpetitoriocategid_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV47GXV1 ;
   private int AV58GXV2 ;
   private long AV32VisibleColumnCount ;
   private String AV46Pgmname ;
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
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV40TFPetitorioCategNombre_Sel ;
   private String AV39TFPetitorioCategNombre ;
   private String AV42TFPetitorioSubCategNombre_Sel ;
   private String AV41TFPetitorioSubCategNombre ;
   private String A266PetitorioCategNombre ;
   private String A265PetitorioSubCategNombre ;
   private String AV49Petitoriosubcategwwds_1_filterfulltext ;
   private String AV54Petitoriosubcategwwds_6_tfpetitoriocategnombre ;
   private String AV55Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel ;
   private String AV56Petitoriosubcategwwds_8_tfpetitoriosubcategnombre ;
   private String AV57Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel ;
   private String lV49Petitoriosubcategwwds_1_filterfulltext ;
   private String lV54Petitoriosubcategwwds_6_tfpetitoriocategnombre ;
   private String lV56Petitoriosubcategwwds_8_tfpetitoriosubcategnombre ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P004V2_A49PetitorioCategId ;
   private short[] P004V2_A48PetitorioSubCategId ;
   private String[] P004V2_A265PetitorioSubCategNombre ;
   private String[] P004V2_A266PetitorioCategNombre ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
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

final  class petitoriosubcategwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004V2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV49Petitoriosubcategwwds_1_filterfulltext ,
                                          short AV50Petitoriosubcategwwds_2_tfpetitoriosubcategid ,
                                          short AV51Petitoriosubcategwwds_3_tfpetitoriosubcategid_to ,
                                          short AV52Petitoriosubcategwwds_4_tfpetitoriocategid ,
                                          short AV53Petitoriosubcategwwds_5_tfpetitoriocategid_to ,
                                          String AV55Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel ,
                                          String AV54Petitoriosubcategwwds_6_tfpetitoriocategnombre ,
                                          String AV57Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel ,
                                          String AV56Petitoriosubcategwwds_8_tfpetitoriosubcategnombre ,
                                          short A48PetitorioSubCategId ,
                                          short A49PetitorioCategId ,
                                          String A266PetitorioCategNombre ,
                                          String A265PetitorioSubCategNombre ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[12];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.[PetitorioCategId], T1.[PetitorioSubCategId], T1.[PetitorioSubCategNombre], T2.[PetitorioCategNombre] FROM ([PetitorioSubCateg] T1 INNER JOIN [PetitorioCateg]" ;
      scmdbuf += " T2 ON T2.[PetitorioCategId] = T1.[PetitorioCategId])" ;
      if ( ! (GXutil.strcmp("", AV49Petitoriosubcategwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[PetitorioSubCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PetitorioCategId] AS decimal(4,0))) like '%' + ?) or ( T2.[PetitorioCategNombre] like '%' + ?) or ( T1.[PetitorioSubCategNombre] like '%' + ?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
         GXv_int10[1] = (byte)(1) ;
         GXv_int10[2] = (byte)(1) ;
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ! (0==AV50Petitoriosubcategwwds_2_tfpetitoriosubcategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] >= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (0==AV51Petitoriosubcategwwds_3_tfpetitoriosubcategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] <= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV52Petitoriosubcategwwds_4_tfpetitoriocategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioCategId] >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (0==AV53Petitoriosubcategwwds_5_tfpetitoriocategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioCategId] <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV55Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel)==0) && ( ! (GXutil.strcmp("", AV54Petitoriosubcategwwds_6_tfpetitoriocategnombre)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategNombre] like ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV55Petitoriosubcategwwds_7_tfpetitoriocategnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategNombre] = ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV57Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel)==0) && ( ! (GXutil.strcmp("", AV56Petitoriosubcategwwds_8_tfpetitoriosubcategnombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategNombre] like ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV57Petitoriosubcategwwds_9_tfpetitoriosubcategnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategNombre] = ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioSubCategNombre]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioSubCategNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioSubCategId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioSubCategId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioCategId]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioCategId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[PetitorioCategNombre]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[PetitorioCategNombre] DESC" ;
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
                  return conditional_P004V2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , ((Boolean) dynConstraints[14]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004V2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[19]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 200);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 200);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 200);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 200);
               }
               return;
      }
   }

}

