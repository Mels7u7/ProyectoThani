package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class petitoriowwexport extends GXProcedure
{
   public petitoriowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( petitoriowwexport.class ), "" );
   }

   public petitoriowwexport( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      petitoriowwexport.this.aP1 = new String[] {""};
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
      petitoriowwexport.this.aP0 = aP0;
      petitoriowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorio", GXv_boolean2) ;
      petitoriowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV58Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "PetitorioWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         petitoriowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFPetitorioId) && (0==AV36TFPetitorioId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFPetitorioId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFPetitorioId_To );
      }
      if ( ! ( (0==AV37TFDrogueriaId) && (0==AV38TFDrogueriaId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Drogueria Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV37TFDrogueriaId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV38TFDrogueriaId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV40TFPetitorioPrincipioActivo_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Principio Activo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFPetitorioPrincipioActivo_Sel, GXv_char7) ;
         petitoriowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFPetitorioPrincipioActivo)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Principio Activo") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFPetitorioPrincipioActivo, GXv_char7) ;
            petitoriowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV42TFPetitorioProducto_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Producto") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFPetitorioProducto_Sel, GXv_char7) ;
         petitoriowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV41TFPetitorioProducto)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Producto") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFPetitorioProducto, GXv_char7) ;
            petitoriowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV43TFPetitorioCategId) && (0==AV44TFPetitorioCategId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Petitorio Categ Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV43TFPetitorioCategId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV44TFPetitorioCategId_To );
      }
      if ( ! ( (0==AV45TFPetitorioSubCategId) && (0==AV46TFPetitorioSubCategId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Sub Categoría") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV45TFPetitorioSubCategId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV46TFPetitorioSubCategId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV48TFPetitorioConcentracion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Concentracion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFPetitorioConcentracion_Sel, GXv_char7) ;
         petitoriowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV47TFPetitorioConcentracion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Concentracion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFPetitorioConcentracion, GXv_char7) ;
            petitoriowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV49TFFormaFarmaceuticaId) && (0==AV50TFFormaFarmaceuticaId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Forma Farmaceutica") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV49TFFormaFarmaceuticaId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV50TFFormaFarmaceuticaId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV52TFPetitorioPresentacion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Presentacion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFPetitorioPresentacion_Sel, GXv_char7) ;
         petitoriowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV51TFPetitorioPresentacion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Presentacion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51TFPetitorioPresentacion, GXv_char7) ;
            petitoriowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFPetitorioPrecio)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFPetitorioPrecio_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Precio") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV53TFPetitorioPrecio)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         petitoriowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV54TFPetitorioPrecio_To)) );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("PetitorioWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("PetitorioWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV59GXV1 = 1 ;
      while ( AV59GXV1 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV59GXV1));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV59GXV1 = (int)(AV59GXV1+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV61Petitoriowwds_1_filterfulltext = AV19FilterFullText ;
      AV62Petitoriowwds_2_tfpetitorioid = AV35TFPetitorioId ;
      AV63Petitoriowwds_3_tfpetitorioid_to = AV36TFPetitorioId_To ;
      AV64Petitoriowwds_4_tfdrogueriaid = AV37TFDrogueriaId ;
      AV65Petitoriowwds_5_tfdrogueriaid_to = AV38TFDrogueriaId_To ;
      AV66Petitoriowwds_6_tfpetitorioprincipioactivo = AV39TFPetitorioPrincipioActivo ;
      AV67Petitoriowwds_7_tfpetitorioprincipioactivo_sel = AV40TFPetitorioPrincipioActivo_Sel ;
      AV68Petitoriowwds_8_tfpetitorioproducto = AV41TFPetitorioProducto ;
      AV69Petitoriowwds_9_tfpetitorioproducto_sel = AV42TFPetitorioProducto_Sel ;
      AV70Petitoriowwds_10_tfpetitoriocategid = AV43TFPetitorioCategId ;
      AV71Petitoriowwds_11_tfpetitoriocategid_to = AV44TFPetitorioCategId_To ;
      AV72Petitoriowwds_12_tfpetitoriosubcategid = AV45TFPetitorioSubCategId ;
      AV73Petitoriowwds_13_tfpetitoriosubcategid_to = AV46TFPetitorioSubCategId_To ;
      AV74Petitoriowwds_14_tfpetitorioconcentracion = AV47TFPetitorioConcentracion ;
      AV75Petitoriowwds_15_tfpetitorioconcentracion_sel = AV48TFPetitorioConcentracion_Sel ;
      AV76Petitoriowwds_16_tfformafarmaceuticaid = AV49TFFormaFarmaceuticaId ;
      AV77Petitoriowwds_17_tfformafarmaceuticaid_to = AV50TFFormaFarmaceuticaId_To ;
      AV78Petitoriowwds_18_tfpetitoriopresentacion = AV51TFPetitorioPresentacion ;
      AV79Petitoriowwds_19_tfpetitoriopresentacion_sel = AV52TFPetitorioPresentacion_Sel ;
      AV80Petitoriowwds_20_tfpetitorioprecio = AV53TFPetitorioPrecio ;
      AV81Petitoriowwds_21_tfpetitorioprecio_to = AV54TFPetitorioPrecio_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV61Petitoriowwds_1_filterfulltext ,
                                           Short.valueOf(AV62Petitoriowwds_2_tfpetitorioid) ,
                                           Short.valueOf(AV63Petitoriowwds_3_tfpetitorioid_to) ,
                                           Short.valueOf(AV64Petitoriowwds_4_tfdrogueriaid) ,
                                           Short.valueOf(AV65Petitoriowwds_5_tfdrogueriaid_to) ,
                                           AV67Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                           AV66Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                           AV69Petitoriowwds_9_tfpetitorioproducto_sel ,
                                           AV68Petitoriowwds_8_tfpetitorioproducto ,
                                           Short.valueOf(AV70Petitoriowwds_10_tfpetitoriocategid) ,
                                           Short.valueOf(AV71Petitoriowwds_11_tfpetitoriocategid_to) ,
                                           Short.valueOf(AV72Petitoriowwds_12_tfpetitoriosubcategid) ,
                                           Short.valueOf(AV73Petitoriowwds_13_tfpetitoriosubcategid_to) ,
                                           AV75Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                           AV74Petitoriowwds_14_tfpetitorioconcentracion ,
                                           Short.valueOf(AV76Petitoriowwds_16_tfformafarmaceuticaid) ,
                                           Short.valueOf(AV77Petitoriowwds_17_tfformafarmaceuticaid_to) ,
                                           AV79Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                           AV78Petitoriowwds_18_tfpetitoriopresentacion ,
                                           AV80Petitoriowwds_20_tfpetitorioprecio ,
                                           AV81Petitoriowwds_21_tfpetitorioprecio_to ,
                                           Short.valueOf(A25PetitorioId) ,
                                           Short.valueOf(A36DrogueriaId) ,
                                           A262PetitorioPrincipioActivo ,
                                           A263PetitorioProducto ,
                                           Short.valueOf(A49PetitorioCategId) ,
                                           Short.valueOf(A48PetitorioSubCategId) ,
                                           A260PetitorioConcentracion ,
                                           Short.valueOf(A39FormaFarmaceuticaId) ,
                                           A261PetitorioPresentacion ,
                                           A264PetitorioPrecio ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV61Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Petitoriowwds_1_filterfulltext), "%", "") ;
      lV61Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Petitoriowwds_1_filterfulltext), "%", "") ;
      lV61Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Petitoriowwds_1_filterfulltext), "%", "") ;
      lV61Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Petitoriowwds_1_filterfulltext), "%", "") ;
      lV61Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Petitoriowwds_1_filterfulltext), "%", "") ;
      lV61Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Petitoriowwds_1_filterfulltext), "%", "") ;
      lV61Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Petitoriowwds_1_filterfulltext), "%", "") ;
      lV61Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Petitoriowwds_1_filterfulltext), "%", "") ;
      lV61Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Petitoriowwds_1_filterfulltext), "%", "") ;
      lV61Petitoriowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Petitoriowwds_1_filterfulltext), "%", "") ;
      lV66Petitoriowwds_6_tfpetitorioprincipioactivo = GXutil.concat( GXutil.rtrim( AV66Petitoriowwds_6_tfpetitorioprincipioactivo), "%", "") ;
      lV68Petitoriowwds_8_tfpetitorioproducto = GXutil.concat( GXutil.rtrim( AV68Petitoriowwds_8_tfpetitorioproducto), "%", "") ;
      lV74Petitoriowwds_14_tfpetitorioconcentracion = GXutil.concat( GXutil.rtrim( AV74Petitoriowwds_14_tfpetitorioconcentracion), "%", "") ;
      lV78Petitoriowwds_18_tfpetitoriopresentacion = GXutil.concat( GXutil.rtrim( AV78Petitoriowwds_18_tfpetitoriopresentacion), "%", "") ;
      /* Using cursor P00492 */
      pr_default.execute(0, new Object[] {lV61Petitoriowwds_1_filterfulltext, lV61Petitoriowwds_1_filterfulltext, lV61Petitoriowwds_1_filterfulltext, lV61Petitoriowwds_1_filterfulltext, lV61Petitoriowwds_1_filterfulltext, lV61Petitoriowwds_1_filterfulltext, lV61Petitoriowwds_1_filterfulltext, lV61Petitoriowwds_1_filterfulltext, lV61Petitoriowwds_1_filterfulltext, lV61Petitoriowwds_1_filterfulltext, Short.valueOf(AV62Petitoriowwds_2_tfpetitorioid), Short.valueOf(AV63Petitoriowwds_3_tfpetitorioid_to), Short.valueOf(AV64Petitoriowwds_4_tfdrogueriaid), Short.valueOf(AV65Petitoriowwds_5_tfdrogueriaid_to), lV66Petitoriowwds_6_tfpetitorioprincipioactivo, AV67Petitoriowwds_7_tfpetitorioprincipioactivo_sel, lV68Petitoriowwds_8_tfpetitorioproducto, AV69Petitoriowwds_9_tfpetitorioproducto_sel, Short.valueOf(AV70Petitoriowwds_10_tfpetitoriocategid), Short.valueOf(AV71Petitoriowwds_11_tfpetitoriocategid_to), Short.valueOf(AV72Petitoriowwds_12_tfpetitoriosubcategid), Short.valueOf(AV73Petitoriowwds_13_tfpetitoriosubcategid_to), lV74Petitoriowwds_14_tfpetitorioconcentracion, AV75Petitoriowwds_15_tfpetitorioconcentracion_sel, Short.valueOf(AV76Petitoriowwds_16_tfformafarmaceuticaid), Short.valueOf(AV77Petitoriowwds_17_tfformafarmaceuticaid_to), lV78Petitoriowwds_18_tfpetitoriopresentacion, AV79Petitoriowwds_19_tfpetitoriopresentacion_sel, AV80Petitoriowwds_20_tfpetitorioprecio, AV81Petitoriowwds_21_tfpetitorioprecio_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A264PetitorioPrecio = P00492_A264PetitorioPrecio[0] ;
         A39FormaFarmaceuticaId = P00492_A39FormaFarmaceuticaId[0] ;
         A48PetitorioSubCategId = P00492_A48PetitorioSubCategId[0] ;
         A49PetitorioCategId = P00492_A49PetitorioCategId[0] ;
         A36DrogueriaId = P00492_A36DrogueriaId[0] ;
         A25PetitorioId = P00492_A25PetitorioId[0] ;
         A261PetitorioPresentacion = P00492_A261PetitorioPresentacion[0] ;
         A260PetitorioConcentracion = P00492_A260PetitorioConcentracion[0] ;
         A263PetitorioProducto = P00492_A263PetitorioProducto[0] ;
         A262PetitorioPrincipioActivo = P00492_A262PetitorioPrincipioActivo[0] ;
         A49PetitorioCategId = P00492_A49PetitorioCategId[0] ;
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
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A25PetitorioId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A36DrogueriaId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A262PetitorioPrincipioActivo, GXv_char7) ;
            petitoriowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A263PetitorioProducto, GXv_char7) ;
            petitoriowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A49PetitorioCategId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A48PetitorioSubCategId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A260PetitorioConcentracion, GXv_char7) ;
            petitoriowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A39FormaFarmaceuticaId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A261PetitorioPresentacion, GXv_char7) ;
            petitoriowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A264PetitorioPrecio)) );
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PetitorioId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DrogueriaId", "", "Drogueria Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PetitorioPrincipioActivo", "", "Principio Activo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PetitorioProducto", "", "Producto", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PetitorioCategId", "", "Petitorio Categ Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PetitorioSubCategId", "", "Sub Categoría", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PetitorioConcentracion", "", "Concentracion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "FormaFarmaceuticaId", "", "Forma Farmaceutica", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PetitorioPresentacion", "", "Presentacion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "PetitorioPrecio", "", "Precio", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "PetitorioWWColumnsSelector", GXv_char7) ;
      petitoriowwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("PetitorioWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PetitorioWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("PetitorioWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV82GXV2 = 1 ;
      while ( AV82GXV2 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV82GXV2));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOID") == 0 )
         {
            AV35TFPetitorioId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFPetitorioId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIAID") == 0 )
         {
            AV37TFDrogueriaId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV38TFDrogueriaId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRINCIPIOACTIVO") == 0 )
         {
            AV39TFPetitorioPrincipioActivo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRINCIPIOACTIVO_SEL") == 0 )
         {
            AV40TFPetitorioPrincipioActivo_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRODUCTO") == 0 )
         {
            AV41TFPetitorioProducto = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRODUCTO_SEL") == 0 )
         {
            AV42TFPetitorioProducto_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCATEGID") == 0 )
         {
            AV43TFPetitorioCategId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV44TFPetitorioCategId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOSUBCATEGID") == 0 )
         {
            AV45TFPetitorioSubCategId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV46TFPetitorioSubCategId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCONCENTRACION") == 0 )
         {
            AV47TFPetitorioConcentracion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOCONCENTRACION_SEL") == 0 )
         {
            AV48TFPetitorioConcentracion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFFORMAFARMACEUTICAID") == 0 )
         {
            AV49TFFormaFarmaceuticaId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV50TFFormaFarmaceuticaId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRESENTACION") == 0 )
         {
            AV51TFPetitorioPresentacion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRESENTACION_SEL") == 0 )
         {
            AV52TFPetitorioPresentacion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPETITORIOPRECIO") == 0 )
         {
            AV53TFPetitorioPrecio = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV54TFPetitorioPrecio_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         AV82GXV2 = (int)(AV82GXV2+1) ;
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
      this.aP0[0] = petitoriowwexport.this.AV12Filename;
      this.aP1[0] = petitoriowwexport.this.AV13ErrorMessage;
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
      AV58Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV40TFPetitorioPrincipioActivo_Sel = "" ;
      AV39TFPetitorioPrincipioActivo = "" ;
      AV42TFPetitorioProducto_Sel = "" ;
      AV41TFPetitorioProducto = "" ;
      AV48TFPetitorioConcentracion_Sel = "" ;
      AV47TFPetitorioConcentracion = "" ;
      AV52TFPetitorioPresentacion_Sel = "" ;
      AV51TFPetitorioPresentacion = "" ;
      AV53TFPetitorioPrecio = DecimalUtil.ZERO ;
      AV54TFPetitorioPrecio_To = DecimalUtil.ZERO ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A262PetitorioPrincipioActivo = "" ;
      A263PetitorioProducto = "" ;
      A260PetitorioConcentracion = "" ;
      A261PetitorioPresentacion = "" ;
      A264PetitorioPrecio = DecimalUtil.ZERO ;
      AV61Petitoriowwds_1_filterfulltext = "" ;
      AV66Petitoriowwds_6_tfpetitorioprincipioactivo = "" ;
      AV67Petitoriowwds_7_tfpetitorioprincipioactivo_sel = "" ;
      AV68Petitoriowwds_8_tfpetitorioproducto = "" ;
      AV69Petitoriowwds_9_tfpetitorioproducto_sel = "" ;
      AV74Petitoriowwds_14_tfpetitorioconcentracion = "" ;
      AV75Petitoriowwds_15_tfpetitorioconcentracion_sel = "" ;
      AV78Petitoriowwds_18_tfpetitoriopresentacion = "" ;
      AV79Petitoriowwds_19_tfpetitoriopresentacion_sel = "" ;
      AV80Petitoriowwds_20_tfpetitorioprecio = DecimalUtil.ZERO ;
      AV81Petitoriowwds_21_tfpetitorioprecio_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV61Petitoriowwds_1_filterfulltext = "" ;
      lV66Petitoriowwds_6_tfpetitorioprincipioactivo = "" ;
      lV68Petitoriowwds_8_tfpetitorioproducto = "" ;
      lV74Petitoriowwds_14_tfpetitorioconcentracion = "" ;
      lV78Petitoriowwds_18_tfpetitoriopresentacion = "" ;
      P00492_A264PetitorioPrecio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00492_A39FormaFarmaceuticaId = new short[1] ;
      P00492_A48PetitorioSubCategId = new short[1] ;
      P00492_A49PetitorioCategId = new short[1] ;
      P00492_A36DrogueriaId = new short[1] ;
      P00492_A25PetitorioId = new short[1] ;
      P00492_A261PetitorioPresentacion = new String[] {""} ;
      P00492_A260PetitorioConcentracion = new String[] {""} ;
      P00492_A263PetitorioProducto = new String[] {""} ;
      P00492_A262PetitorioPrincipioActivo = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.petitoriowwexport__default(),
         new Object[] {
             new Object[] {
            P00492_A264PetitorioPrecio, P00492_A39FormaFarmaceuticaId, P00492_A48PetitorioSubCategId, P00492_A49PetitorioCategId, P00492_A36DrogueriaId, P00492_A25PetitorioId, P00492_A261PetitorioPresentacion, P00492_A260PetitorioConcentracion, P00492_A263PetitorioProducto, P00492_A262PetitorioPrincipioActivo
            }
         }
      );
      AV58Pgmname = "PetitorioWWExport" ;
      /* GeneXus formulas. */
      AV58Pgmname = "PetitorioWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV35TFPetitorioId ;
   private short AV36TFPetitorioId_To ;
   private short AV37TFDrogueriaId ;
   private short AV38TFDrogueriaId_To ;
   private short AV43TFPetitorioCategId ;
   private short AV44TFPetitorioCategId_To ;
   private short AV45TFPetitorioSubCategId ;
   private short AV46TFPetitorioSubCategId_To ;
   private short AV49TFFormaFarmaceuticaId ;
   private short AV50TFFormaFarmaceuticaId_To ;
   private short GXv_int5[] ;
   private short A25PetitorioId ;
   private short A36DrogueriaId ;
   private short A49PetitorioCategId ;
   private short A48PetitorioSubCategId ;
   private short A39FormaFarmaceuticaId ;
   private short AV62Petitoriowwds_2_tfpetitorioid ;
   private short AV63Petitoriowwds_3_tfpetitorioid_to ;
   private short AV64Petitoriowwds_4_tfdrogueriaid ;
   private short AV65Petitoriowwds_5_tfdrogueriaid_to ;
   private short AV70Petitoriowwds_10_tfpetitoriocategid ;
   private short AV71Petitoriowwds_11_tfpetitoriocategid_to ;
   private short AV72Petitoriowwds_12_tfpetitoriosubcategid ;
   private short AV73Petitoriowwds_13_tfpetitoriosubcategid_to ;
   private short AV76Petitoriowwds_16_tfformafarmaceuticaid ;
   private short AV77Petitoriowwds_17_tfformafarmaceuticaid_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV59GXV1 ;
   private int AV82GXV2 ;
   private long AV32VisibleColumnCount ;
   private java.math.BigDecimal AV53TFPetitorioPrecio ;
   private java.math.BigDecimal AV54TFPetitorioPrecio_To ;
   private java.math.BigDecimal A264PetitorioPrecio ;
   private java.math.BigDecimal AV80Petitoriowwds_20_tfpetitorioprecio ;
   private java.math.BigDecimal AV81Petitoriowwds_21_tfpetitorioprecio_to ;
   private String AV58Pgmname ;
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
   private String AV40TFPetitorioPrincipioActivo_Sel ;
   private String AV39TFPetitorioPrincipioActivo ;
   private String AV42TFPetitorioProducto_Sel ;
   private String AV41TFPetitorioProducto ;
   private String AV48TFPetitorioConcentracion_Sel ;
   private String AV47TFPetitorioConcentracion ;
   private String AV52TFPetitorioPresentacion_Sel ;
   private String AV51TFPetitorioPresentacion ;
   private String A262PetitorioPrincipioActivo ;
   private String A263PetitorioProducto ;
   private String A260PetitorioConcentracion ;
   private String A261PetitorioPresentacion ;
   private String AV61Petitoriowwds_1_filterfulltext ;
   private String AV66Petitoriowwds_6_tfpetitorioprincipioactivo ;
   private String AV67Petitoriowwds_7_tfpetitorioprincipioactivo_sel ;
   private String AV68Petitoriowwds_8_tfpetitorioproducto ;
   private String AV69Petitoriowwds_9_tfpetitorioproducto_sel ;
   private String AV74Petitoriowwds_14_tfpetitorioconcentracion ;
   private String AV75Petitoriowwds_15_tfpetitorioconcentracion_sel ;
   private String AV78Petitoriowwds_18_tfpetitoriopresentacion ;
   private String AV79Petitoriowwds_19_tfpetitoriopresentacion_sel ;
   private String lV61Petitoriowwds_1_filterfulltext ;
   private String lV66Petitoriowwds_6_tfpetitorioprincipioactivo ;
   private String lV68Petitoriowwds_8_tfpetitorioproducto ;
   private String lV74Petitoriowwds_14_tfpetitorioconcentracion ;
   private String lV78Petitoriowwds_18_tfpetitoriopresentacion ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P00492_A264PetitorioPrecio ;
   private short[] P00492_A39FormaFarmaceuticaId ;
   private short[] P00492_A48PetitorioSubCategId ;
   private short[] P00492_A49PetitorioCategId ;
   private short[] P00492_A36DrogueriaId ;
   private short[] P00492_A25PetitorioId ;
   private String[] P00492_A261PetitorioPresentacion ;
   private String[] P00492_A260PetitorioConcentracion ;
   private String[] P00492_A263PetitorioProducto ;
   private String[] P00492_A262PetitorioPrincipioActivo ;
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

final  class petitoriowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00492( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV61Petitoriowwds_1_filterfulltext ,
                                          short AV62Petitoriowwds_2_tfpetitorioid ,
                                          short AV63Petitoriowwds_3_tfpetitorioid_to ,
                                          short AV64Petitoriowwds_4_tfdrogueriaid ,
                                          short AV65Petitoriowwds_5_tfdrogueriaid_to ,
                                          String AV67Petitoriowwds_7_tfpetitorioprincipioactivo_sel ,
                                          String AV66Petitoriowwds_6_tfpetitorioprincipioactivo ,
                                          String AV69Petitoriowwds_9_tfpetitorioproducto_sel ,
                                          String AV68Petitoriowwds_8_tfpetitorioproducto ,
                                          short AV70Petitoriowwds_10_tfpetitoriocategid ,
                                          short AV71Petitoriowwds_11_tfpetitoriocategid_to ,
                                          short AV72Petitoriowwds_12_tfpetitoriosubcategid ,
                                          short AV73Petitoriowwds_13_tfpetitoriosubcategid_to ,
                                          String AV75Petitoriowwds_15_tfpetitorioconcentracion_sel ,
                                          String AV74Petitoriowwds_14_tfpetitorioconcentracion ,
                                          short AV76Petitoriowwds_16_tfformafarmaceuticaid ,
                                          short AV77Petitoriowwds_17_tfformafarmaceuticaid_to ,
                                          String AV79Petitoriowwds_19_tfpetitoriopresentacion_sel ,
                                          String AV78Petitoriowwds_18_tfpetitoriopresentacion ,
                                          java.math.BigDecimal AV80Petitoriowwds_20_tfpetitorioprecio ,
                                          java.math.BigDecimal AV81Petitoriowwds_21_tfpetitorioprecio_to ,
                                          short A25PetitorioId ,
                                          short A36DrogueriaId ,
                                          String A262PetitorioPrincipioActivo ,
                                          String A263PetitorioProducto ,
                                          short A49PetitorioCategId ,
                                          short A48PetitorioSubCategId ,
                                          String A260PetitorioConcentracion ,
                                          short A39FormaFarmaceuticaId ,
                                          String A261PetitorioPresentacion ,
                                          java.math.BigDecimal A264PetitorioPrecio ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[30];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.[PetitorioPrecio], T1.[FormaFarmaceuticaId], T1.[PetitorioSubCategId], T2.[PetitorioCategId], T1.[DrogueriaId], T1.[PetitorioId], T1.[PetitorioPresentacion]," ;
      scmdbuf += " T1.[PetitorioConcentracion], T1.[PetitorioProducto], T1.[PetitorioPrincipioActivo] FROM ([Petitorio] T1 INNER JOIN [PetitorioSubCateg] T2 ON T2.[PetitorioSubCategId]" ;
      scmdbuf += " = T1.[PetitorioSubCategId])" ;
      if ( ! (GXutil.strcmp("", AV61Petitoriowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST(T1.[PetitorioId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[DrogueriaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPrincipioActivo] like '%' + ?) or ( T1.[PetitorioProducto] like '%' + ?) or ( CONVERT( char(4), CAST(T2.[PetitorioCategId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(4), CAST(T1.[PetitorioSubCategId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioConcentracion] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[FormaFarmaceuticaId] AS decimal(4,0))) like '%' + ?) or ( T1.[PetitorioPresentacion] like '%' + ?) or ( CONVERT( char(7), CAST(T1.[PetitorioPrecio] AS decimal(7,2))) like '%' + ?))");
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
         GXv_int10[8] = (byte)(1) ;
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (0==AV62Petitoriowwds_2_tfpetitorioid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] >= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (0==AV63Petitoriowwds_3_tfpetitorioid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioId] <= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (0==AV64Petitoriowwds_4_tfdrogueriaid) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] >= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (0==AV65Petitoriowwds_5_tfdrogueriaid_to) )
      {
         addWhere(sWhereString, "(T1.[DrogueriaId] <= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV67Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) && ( ! (GXutil.strcmp("", AV66Petitoriowwds_6_tfpetitorioprincipioactivo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] like ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV67Petitoriowwds_7_tfpetitorioprincipioactivo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrincipioActivo] = ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV69Petitoriowwds_9_tfpetitorioproducto_sel)==0) && ( ! (GXutil.strcmp("", AV68Petitoriowwds_8_tfpetitorioproducto)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] like ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV69Petitoriowwds_9_tfpetitorioproducto_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioProducto] = ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (0==AV70Petitoriowwds_10_tfpetitoriocategid) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] >= ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( ! (0==AV71Petitoriowwds_11_tfpetitoriocategid_to) )
      {
         addWhere(sWhereString, "(T2.[PetitorioCategId] <= ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( ! (0==AV72Petitoriowwds_12_tfpetitoriosubcategid) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] >= ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( ! (0==AV73Petitoriowwds_13_tfpetitoriosubcategid_to) )
      {
         addWhere(sWhereString, "(T1.[PetitorioSubCategId] <= ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV75Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) && ( ! (GXutil.strcmp("", AV74Petitoriowwds_14_tfpetitorioconcentracion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] like ?)");
      }
      else
      {
         GXv_int10[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV75Petitoriowwds_15_tfpetitorioconcentracion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioConcentracion] = ?)");
      }
      else
      {
         GXv_int10[23] = (byte)(1) ;
      }
      if ( ! (0==AV76Petitoriowwds_16_tfformafarmaceuticaid) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] >= ?)");
      }
      else
      {
         GXv_int10[24] = (byte)(1) ;
      }
      if ( ! (0==AV77Petitoriowwds_17_tfformafarmaceuticaid_to) )
      {
         addWhere(sWhereString, "(T1.[FormaFarmaceuticaId] <= ?)");
      }
      else
      {
         GXv_int10[25] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV79Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) && ( ! (GXutil.strcmp("", AV78Petitoriowwds_18_tfpetitoriopresentacion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] like ?)");
      }
      else
      {
         GXv_int10[26] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV79Petitoriowwds_19_tfpetitoriopresentacion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPresentacion] = ?)");
      }
      else
      {
         GXv_int10[27] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Petitoriowwds_20_tfpetitorioprecio)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] >= ?)");
      }
      else
      {
         GXv_int10[28] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV81Petitoriowwds_21_tfpetitorioprecio_to)==0) )
      {
         addWhere(sWhereString, "(T1.[PetitorioPrecio] <= ?)");
      }
      else
      {
         GXv_int10[29] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioPrincipioActivo]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioPrincipioActivo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DrogueriaId]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DrogueriaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioProducto]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioProducto] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[PetitorioCategId]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[PetitorioCategId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioSubCategId]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioSubCategId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioConcentracion]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioConcentracion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[FormaFarmaceuticaId]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[FormaFarmaceuticaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioPresentacion]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioPresentacion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[PetitorioPrecio]" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[PetitorioPrecio] DESC" ;
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
                  return conditional_P00492(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Boolean) dynConstraints[32]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00492", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
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
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[42]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[43]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 200);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 200);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[49]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[50]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 40);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 40);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[54]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[55]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 40);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 40);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[58], 2);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[59], 2);
               }
               return;
      }
   }

}

