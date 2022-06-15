package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clinicawwexport extends GXProcedure
{
   public clinicawwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clinicawwexport.class ), "" );
   }

   public clinicawwexport( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      clinicawwexport.this.aP1 = new String[] {""};
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
      clinicawwexport.this.aP0 = aP0;
      clinicawwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClinica", GXv_boolean2) ;
      clinicawwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV71Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "ClinicaWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFClinicaId) && (0==AV36TFClinicaId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFClinicaId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFClinicaId_To );
      }
      if ( ! ( (0==AV37TFClinicaRUC) && (0==AV38TFClinicaRUC_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "RUC") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV37TFClinicaRUC );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV38TFClinicaRUC_To );
      }
      if ( ! ( (GXutil.strcmp("", AV40TFClinicaNombreComercial_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre Comercial") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFClinicaNombreComercial_Sel, GXv_char7) ;
         clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFClinicaNombreComercial)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre Comercial") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFClinicaNombreComercial, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV42TFClinicaNombreAbreviado_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre Abrev.") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFClinicaNombreAbreviado_Sel, GXv_char7) ;
         clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV41TFClinicaNombreAbreviado)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre Abrev.") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFClinicaNombreAbreviado, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV44TFClinicaDireccionComercial_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Direccion Comercial") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFClinicaDireccionComercial_Sel, GXv_char7) ;
         clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV43TFClinicaDireccionComercial)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Direccion Comercial") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFClinicaDireccionComercial, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV46TFClinicaCorreo_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Correo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFClinicaCorreo_Sel, GXv_char7) ;
         clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFClinicaCorreo)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Correo") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFClinicaCorreo, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV48TFClinicaMoneda_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Moneda") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV68i = 1 ;
         AV72GXV1 = 1 ;
         while ( AV72GXV1 <= AV48TFClinicaMoneda_Sels.size() )
         {
            AV49TFClinicaMoneda_Sel = ((Number) AV48TFClinicaMoneda_Sels.elementAt(-1+AV72GXV1)).shortValue() ;
            if ( AV68i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainmoneda.getDescription(httpContext,(short)AV49TFClinicaMoneda_Sel) );
            AV68i = (long)(AV68i+1) ;
            AV72GXV1 = (int)(AV72GXV1+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV51TFClinicaTelefono_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Telefono") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51TFClinicaTelefono_Sel, GXv_char7) ;
         clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV50TFClinicaTelefono)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Telefono") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFClinicaTelefono, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV53TFClinicaWhatsApp_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Whats App") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV53TFClinicaWhatsApp_Sel, GXv_char7) ;
         clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV52TFClinicaWhatsApp)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Whats App") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFClinicaWhatsApp, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV55TFClinicaFacebook_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Facebook") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV55TFClinicaFacebook_Sel, GXv_char7) ;
         clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV54TFClinicaFacebook)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Facebook") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV54TFClinicaFacebook, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV57TFClinicaTwiter_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Twiter") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV57TFClinicaTwiter_Sel, GXv_char7) ;
         clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV56TFClinicaTwiter)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Twiter") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV56TFClinicaTwiter, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV59TFClinicaInstagram_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Instagram") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV59TFClinicaInstagram_Sel, GXv_char7) ;
         clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV58TFClinicaInstagram)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Instagram") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV58TFClinicaInstagram, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV61TFClinicaLinkedin_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Linkedin") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV61TFClinicaLinkedin_Sel, GXv_char7) ;
         clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV60TFClinicaLinkedin)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Linkedin") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV60TFClinicaLinkedin, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV63TFClinicaTiempoDeCita_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Tiempo De Cita") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV68i = 1 ;
         AV73GXV2 = 1 ;
         while ( AV73GXV2 <= AV63TFClinicaTiempoDeCita_Sels.size() )
         {
            AV64TFClinicaTiempoDeCita_Sel = ((Number) AV63TFClinicaTiempoDeCita_Sels.elementAt(-1+AV73GXV2)).byteValue() ;
            if ( AV68i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomaintiempocita.getDescription(httpContext,(byte)AV64TFClinicaTiempoDeCita_Sel) );
            AV68i = (long)(AV68i+1) ;
            AV73GXV2 = (int)(AV73GXV2+1) ;
         }
      }
      if ( ! ( ( AV66TFClinicaEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estado") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         clinicawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV68i = 1 ;
         AV74GXV3 = 1 ;
         while ( AV74GXV3 <= AV66TFClinicaEstado_Sels.size() )
         {
            AV67TFClinicaEstado_Sel = (String)AV66TFClinicaEstado_Sels.elementAt(-1+AV74GXV3) ;
            if ( AV68i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV67TFClinicaEstado_Sel) );
            AV68i = (long)(AV68i+1) ;
            AV74GXV3 = (int)(AV74GXV3+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("ClinicaWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("ClinicaWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV75GXV4 = 1 ;
      while ( AV75GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV75GXV4));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV75GXV4 = (int)(AV75GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV77Clinicawwds_1_filterfulltext = AV19FilterFullText ;
      AV78Clinicawwds_2_tfclinicaid = AV35TFClinicaId ;
      AV79Clinicawwds_3_tfclinicaid_to = AV36TFClinicaId_To ;
      AV80Clinicawwds_4_tfclinicaruc = AV37TFClinicaRUC ;
      AV81Clinicawwds_5_tfclinicaruc_to = AV38TFClinicaRUC_To ;
      AV82Clinicawwds_6_tfclinicanombrecomercial = AV39TFClinicaNombreComercial ;
      AV83Clinicawwds_7_tfclinicanombrecomercial_sel = AV40TFClinicaNombreComercial_Sel ;
      AV84Clinicawwds_8_tfclinicanombreabreviado = AV41TFClinicaNombreAbreviado ;
      AV85Clinicawwds_9_tfclinicanombreabreviado_sel = AV42TFClinicaNombreAbreviado_Sel ;
      AV86Clinicawwds_10_tfclinicadireccioncomercial = AV43TFClinicaDireccionComercial ;
      AV87Clinicawwds_11_tfclinicadireccioncomercial_sel = AV44TFClinicaDireccionComercial_Sel ;
      AV88Clinicawwds_12_tfclinicacorreo = AV45TFClinicaCorreo ;
      AV89Clinicawwds_13_tfclinicacorreo_sel = AV46TFClinicaCorreo_Sel ;
      AV90Clinicawwds_14_tfclinicamoneda_sels = AV48TFClinicaMoneda_Sels ;
      AV91Clinicawwds_15_tfclinicatelefono = AV50TFClinicaTelefono ;
      AV92Clinicawwds_16_tfclinicatelefono_sel = AV51TFClinicaTelefono_Sel ;
      AV93Clinicawwds_17_tfclinicawhatsapp = AV52TFClinicaWhatsApp ;
      AV94Clinicawwds_18_tfclinicawhatsapp_sel = AV53TFClinicaWhatsApp_Sel ;
      AV95Clinicawwds_19_tfclinicafacebook = AV54TFClinicaFacebook ;
      AV96Clinicawwds_20_tfclinicafacebook_sel = AV55TFClinicaFacebook_Sel ;
      AV97Clinicawwds_21_tfclinicatwiter = AV56TFClinicaTwiter ;
      AV98Clinicawwds_22_tfclinicatwiter_sel = AV57TFClinicaTwiter_Sel ;
      AV99Clinicawwds_23_tfclinicainstagram = AV58TFClinicaInstagram ;
      AV100Clinicawwds_24_tfclinicainstagram_sel = AV59TFClinicaInstagram_Sel ;
      AV101Clinicawwds_25_tfclinicalinkedin = AV60TFClinicaLinkedin ;
      AV102Clinicawwds_26_tfclinicalinkedin_sel = AV61TFClinicaLinkedin_Sel ;
      AV103Clinicawwds_27_tfclinicatiempodecita_sels = AV63TFClinicaTiempoDeCita_Sels ;
      AV104Clinicawwds_28_tfclinicaestado_sels = AV66TFClinicaEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(A341ClinicaMoneda) ,
                                           AV90Clinicawwds_14_tfclinicamoneda_sels ,
                                           Byte.valueOf(A120ClinicaTiempoDeCita) ,
                                           AV103Clinicawwds_27_tfclinicatiempodecita_sels ,
                                           A121ClinicaEstado ,
                                           AV104Clinicawwds_28_tfclinicaestado_sels ,
                                           AV77Clinicawwds_1_filterfulltext ,
                                           Short.valueOf(AV78Clinicawwds_2_tfclinicaid) ,
                                           Short.valueOf(AV79Clinicawwds_3_tfclinicaid_to) ,
                                           Long.valueOf(AV80Clinicawwds_4_tfclinicaruc) ,
                                           Long.valueOf(AV81Clinicawwds_5_tfclinicaruc_to) ,
                                           AV83Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                           AV82Clinicawwds_6_tfclinicanombrecomercial ,
                                           AV85Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                           AV84Clinicawwds_8_tfclinicanombreabreviado ,
                                           AV87Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                           AV86Clinicawwds_10_tfclinicadireccioncomercial ,
                                           AV89Clinicawwds_13_tfclinicacorreo_sel ,
                                           AV88Clinicawwds_12_tfclinicacorreo ,
                                           Integer.valueOf(AV90Clinicawwds_14_tfclinicamoneda_sels.size()) ,
                                           AV92Clinicawwds_16_tfclinicatelefono_sel ,
                                           AV91Clinicawwds_15_tfclinicatelefono ,
                                           AV94Clinicawwds_18_tfclinicawhatsapp_sel ,
                                           AV93Clinicawwds_17_tfclinicawhatsapp ,
                                           AV96Clinicawwds_20_tfclinicafacebook_sel ,
                                           AV95Clinicawwds_19_tfclinicafacebook ,
                                           AV98Clinicawwds_22_tfclinicatwiter_sel ,
                                           AV97Clinicawwds_21_tfclinicatwiter ,
                                           AV100Clinicawwds_24_tfclinicainstagram_sel ,
                                           AV99Clinicawwds_23_tfclinicainstagram ,
                                           AV102Clinicawwds_26_tfclinicalinkedin_sel ,
                                           AV101Clinicawwds_25_tfclinicalinkedin ,
                                           Integer.valueOf(AV103Clinicawwds_27_tfclinicatiempodecita_sels.size()) ,
                                           Integer.valueOf(AV104Clinicawwds_28_tfclinicaestado_sels.size()) ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A80ClinicaNombreAbreviado ,
                                           A119ClinicaDireccionComercial ,
                                           A340ClinicaCorreo ,
                                           A346ClinicaTelefono ,
                                           A347ClinicaWhatsApp ,
                                           A348ClinicaFacebook ,
                                           A349ClinicaTwiter ,
                                           A350ClinicaInstagram ,
                                           A351ClinicaLinkedin ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV77Clinicawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV77Clinicawwds_1_filterfulltext), "%", "") ;
      lV82Clinicawwds_6_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV82Clinicawwds_6_tfclinicanombrecomercial), "%", "") ;
      lV84Clinicawwds_8_tfclinicanombreabreviado = GXutil.concat( GXutil.rtrim( AV84Clinicawwds_8_tfclinicanombreabreviado), "%", "") ;
      lV86Clinicawwds_10_tfclinicadireccioncomercial = GXutil.concat( GXutil.rtrim( AV86Clinicawwds_10_tfclinicadireccioncomercial), "%", "") ;
      lV88Clinicawwds_12_tfclinicacorreo = GXutil.concat( GXutil.rtrim( AV88Clinicawwds_12_tfclinicacorreo), "%", "") ;
      lV91Clinicawwds_15_tfclinicatelefono = GXutil.padr( GXutil.rtrim( AV91Clinicawwds_15_tfclinicatelefono), 12, "%") ;
      lV93Clinicawwds_17_tfclinicawhatsapp = GXutil.padr( GXutil.rtrim( AV93Clinicawwds_17_tfclinicawhatsapp), 15, "%") ;
      lV95Clinicawwds_19_tfclinicafacebook = GXutil.concat( GXutil.rtrim( AV95Clinicawwds_19_tfclinicafacebook), "%", "") ;
      lV97Clinicawwds_21_tfclinicatwiter = GXutil.concat( GXutil.rtrim( AV97Clinicawwds_21_tfclinicatwiter), "%", "") ;
      lV99Clinicawwds_23_tfclinicainstagram = GXutil.concat( GXutil.rtrim( AV99Clinicawwds_23_tfclinicainstagram), "%", "") ;
      lV101Clinicawwds_25_tfclinicalinkedin = GXutil.concat( GXutil.rtrim( AV101Clinicawwds_25_tfclinicalinkedin), "%", "") ;
      /* Using cursor P008H2 */
      pr_default.execute(0, new Object[] {lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, lV77Clinicawwds_1_filterfulltext, Short.valueOf(AV78Clinicawwds_2_tfclinicaid), Short.valueOf(AV79Clinicawwds_3_tfclinicaid_to), Long.valueOf(AV80Clinicawwds_4_tfclinicaruc), Long.valueOf(AV81Clinicawwds_5_tfclinicaruc_to), lV82Clinicawwds_6_tfclinicanombrecomercial, AV83Clinicawwds_7_tfclinicanombrecomercial_sel, lV84Clinicawwds_8_tfclinicanombreabreviado, AV85Clinicawwds_9_tfclinicanombreabreviado_sel, lV86Clinicawwds_10_tfclinicadireccioncomercial, AV87Clinicawwds_11_tfclinicadireccioncomercial_sel, lV88Clinicawwds_12_tfclinicacorreo, AV89Clinicawwds_13_tfclinicacorreo_sel, lV91Clinicawwds_15_tfclinicatelefono, AV92Clinicawwds_16_tfclinicatelefono_sel, lV93Clinicawwds_17_tfclinicawhatsapp, AV94Clinicawwds_18_tfclinicawhatsapp_sel, lV95Clinicawwds_19_tfclinicafacebook, AV96Clinicawwds_20_tfclinicafacebook_sel, lV97Clinicawwds_21_tfclinicatwiter, AV98Clinicawwds_22_tfclinicatwiter_sel, lV99Clinicawwds_23_tfclinicainstagram, AV100Clinicawwds_24_tfclinicainstagram_sel, lV101Clinicawwds_25_tfclinicalinkedin, AV102Clinicawwds_26_tfclinicalinkedin_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A118ClinicaRUC = P008H2_A118ClinicaRUC[0] ;
         A28ClinicaId = P008H2_A28ClinicaId[0] ;
         A121ClinicaEstado = P008H2_A121ClinicaEstado[0] ;
         A120ClinicaTiempoDeCita = P008H2_A120ClinicaTiempoDeCita[0] ;
         A351ClinicaLinkedin = P008H2_A351ClinicaLinkedin[0] ;
         A350ClinicaInstagram = P008H2_A350ClinicaInstagram[0] ;
         A349ClinicaTwiter = P008H2_A349ClinicaTwiter[0] ;
         A348ClinicaFacebook = P008H2_A348ClinicaFacebook[0] ;
         A347ClinicaWhatsApp = P008H2_A347ClinicaWhatsApp[0] ;
         A346ClinicaTelefono = P008H2_A346ClinicaTelefono[0] ;
         A341ClinicaMoneda = P008H2_A341ClinicaMoneda[0] ;
         A340ClinicaCorreo = P008H2_A340ClinicaCorreo[0] ;
         A119ClinicaDireccionComercial = P008H2_A119ClinicaDireccionComercial[0] ;
         A80ClinicaNombreAbreviado = P008H2_A80ClinicaNombreAbreviado[0] ;
         A116ClinicaNombreComercial = P008H2_A116ClinicaNombreComercial[0] ;
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
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A28ClinicaId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A118ClinicaRUC );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A116ClinicaNombreComercial, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A80ClinicaNombreAbreviado, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A119ClinicaDireccionComercial, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A340ClinicaCorreo, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainmoneda.getDescription(httpContext,(short)A341ClinicaMoneda) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "" );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "" );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "" );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "" );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( "" );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A346ClinicaTelefono, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A347ClinicaWhatsApp, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A348ClinicaFacebook, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A349ClinicaTwiter, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A350ClinicaInstagram, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A351ClinicaLinkedin, GXv_char7) ;
            clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomaintiempocita.getDescription(httpContext,(byte)A120ClinicaTiempoDeCita) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestado.getDescription(httpContext,(String)A121ClinicaEstado) );
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaRUC", "", "RUC", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaNombreComercial", "", "Nombre Comercial", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaNombreAbreviado", "", "Nombre Abrev.", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaDireccionComercial", "", "Direccion Comercial", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaCorreo", "", "Correo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaMoneda", "", "Moneda", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaLogo", "", "Logo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaLogoHeader", "", "Logo Header", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaLogoFactura", "", "Logo Factura", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaLogoBoleta", "", "Logo Boleta", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaLogoPago", "", "Logo Pago", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaTelefono", "", "Telefono", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaWhatsApp", "", "Whats App", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaFacebook", "", "Facebook", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaTwiter", "", "Twiter", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaInstagram", "", "Instagram", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaLinkedin", "", "Linkedin", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaTiempoDeCita", "", "Tiempo De Cita", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaEstado", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ClinicaWWColumnsSelector", GXv_char7) ;
      clinicawwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("ClinicaWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ClinicaWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ClinicaWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV105GXV5 = 1 ;
      while ( AV105GXV5 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV105GXV5));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAID") == 0 )
         {
            AV35TFClinicaId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFClinicaId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICARUC") == 0 )
         {
            AV37TFClinicaRUC = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV38TFClinicaRUC_To = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL") == 0 )
         {
            AV39TFClinicaNombreComercial = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL_SEL") == 0 )
         {
            AV40TFClinicaNombreComercial_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBREABREVIADO") == 0 )
         {
            AV41TFClinicaNombreAbreviado = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBREABREVIADO_SEL") == 0 )
         {
            AV42TFClinicaNombreAbreviado_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICADIRECCIONCOMERCIAL") == 0 )
         {
            AV43TFClinicaDireccionComercial = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICADIRECCIONCOMERCIAL_SEL") == 0 )
         {
            AV44TFClinicaDireccionComercial_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICACORREO") == 0 )
         {
            AV45TFClinicaCorreo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICACORREO_SEL") == 0 )
         {
            AV46TFClinicaCorreo_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAMONEDA_SEL") == 0 )
         {
            AV47TFClinicaMoneda_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFClinicaMoneda_Sels.fromJSonString(AV47TFClinicaMoneda_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATELEFONO") == 0 )
         {
            AV50TFClinicaTelefono = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATELEFONO_SEL") == 0 )
         {
            AV51TFClinicaTelefono_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAWHATSAPP") == 0 )
         {
            AV52TFClinicaWhatsApp = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAWHATSAPP_SEL") == 0 )
         {
            AV53TFClinicaWhatsApp_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAFACEBOOK") == 0 )
         {
            AV54TFClinicaFacebook = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAFACEBOOK_SEL") == 0 )
         {
            AV55TFClinicaFacebook_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATWITER") == 0 )
         {
            AV56TFClinicaTwiter = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATWITER_SEL") == 0 )
         {
            AV57TFClinicaTwiter_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAINSTAGRAM") == 0 )
         {
            AV58TFClinicaInstagram = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAINSTAGRAM_SEL") == 0 )
         {
            AV59TFClinicaInstagram_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICALINKEDIN") == 0 )
         {
            AV60TFClinicaLinkedin = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICALINKEDIN_SEL") == 0 )
         {
            AV61TFClinicaLinkedin_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICATIEMPODECITA_SEL") == 0 )
         {
            AV62TFClinicaTiempoDeCita_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV63TFClinicaTiempoDeCita_Sels.fromJSonString(AV62TFClinicaTiempoDeCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAESTADO_SEL") == 0 )
         {
            AV65TFClinicaEstado_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV66TFClinicaEstado_Sels.fromJSonString(AV65TFClinicaEstado_SelsJson, null);
         }
         AV105GXV5 = (int)(AV105GXV5+1) ;
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
      this.aP0[0] = clinicawwexport.this.AV12Filename;
      this.aP1[0] = clinicawwexport.this.AV13ErrorMessage;
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
      AV71Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV40TFClinicaNombreComercial_Sel = "" ;
      AV39TFClinicaNombreComercial = "" ;
      AV42TFClinicaNombreAbreviado_Sel = "" ;
      AV41TFClinicaNombreAbreviado = "" ;
      AV44TFClinicaDireccionComercial_Sel = "" ;
      AV43TFClinicaDireccionComercial = "" ;
      AV46TFClinicaCorreo_Sel = "" ;
      AV45TFClinicaCorreo = "" ;
      AV48TFClinicaMoneda_Sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV51TFClinicaTelefono_Sel = "" ;
      AV50TFClinicaTelefono = "" ;
      AV53TFClinicaWhatsApp_Sel = "" ;
      AV52TFClinicaWhatsApp = "" ;
      AV55TFClinicaFacebook_Sel = "" ;
      AV54TFClinicaFacebook = "" ;
      AV57TFClinicaTwiter_Sel = "" ;
      AV56TFClinicaTwiter = "" ;
      AV59TFClinicaInstagram_Sel = "" ;
      AV58TFClinicaInstagram = "" ;
      AV61TFClinicaLinkedin_Sel = "" ;
      AV60TFClinicaLinkedin = "" ;
      AV63TFClinicaTiempoDeCita_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV66TFClinicaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV67TFClinicaEstado_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A116ClinicaNombreComercial = "" ;
      A80ClinicaNombreAbreviado = "" ;
      A119ClinicaDireccionComercial = "" ;
      A340ClinicaCorreo = "" ;
      A346ClinicaTelefono = "" ;
      A347ClinicaWhatsApp = "" ;
      A348ClinicaFacebook = "" ;
      A349ClinicaTwiter = "" ;
      A350ClinicaInstagram = "" ;
      A351ClinicaLinkedin = "" ;
      A121ClinicaEstado = "" ;
      AV77Clinicawwds_1_filterfulltext = "" ;
      AV82Clinicawwds_6_tfclinicanombrecomercial = "" ;
      AV83Clinicawwds_7_tfclinicanombrecomercial_sel = "" ;
      AV84Clinicawwds_8_tfclinicanombreabreviado = "" ;
      AV85Clinicawwds_9_tfclinicanombreabreviado_sel = "" ;
      AV86Clinicawwds_10_tfclinicadireccioncomercial = "" ;
      AV87Clinicawwds_11_tfclinicadireccioncomercial_sel = "" ;
      AV88Clinicawwds_12_tfclinicacorreo = "" ;
      AV89Clinicawwds_13_tfclinicacorreo_sel = "" ;
      AV90Clinicawwds_14_tfclinicamoneda_sels = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV91Clinicawwds_15_tfclinicatelefono = "" ;
      AV92Clinicawwds_16_tfclinicatelefono_sel = "" ;
      AV93Clinicawwds_17_tfclinicawhatsapp = "" ;
      AV94Clinicawwds_18_tfclinicawhatsapp_sel = "" ;
      AV95Clinicawwds_19_tfclinicafacebook = "" ;
      AV96Clinicawwds_20_tfclinicafacebook_sel = "" ;
      AV97Clinicawwds_21_tfclinicatwiter = "" ;
      AV98Clinicawwds_22_tfclinicatwiter_sel = "" ;
      AV99Clinicawwds_23_tfclinicainstagram = "" ;
      AV100Clinicawwds_24_tfclinicainstagram_sel = "" ;
      AV101Clinicawwds_25_tfclinicalinkedin = "" ;
      AV102Clinicawwds_26_tfclinicalinkedin_sel = "" ;
      AV103Clinicawwds_27_tfclinicatiempodecita_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV104Clinicawwds_28_tfclinicaestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV77Clinicawwds_1_filterfulltext = "" ;
      lV82Clinicawwds_6_tfclinicanombrecomercial = "" ;
      lV84Clinicawwds_8_tfclinicanombreabreviado = "" ;
      lV86Clinicawwds_10_tfclinicadireccioncomercial = "" ;
      lV88Clinicawwds_12_tfclinicacorreo = "" ;
      lV91Clinicawwds_15_tfclinicatelefono = "" ;
      lV93Clinicawwds_17_tfclinicawhatsapp = "" ;
      lV95Clinicawwds_19_tfclinicafacebook = "" ;
      lV97Clinicawwds_21_tfclinicatwiter = "" ;
      lV99Clinicawwds_23_tfclinicainstagram = "" ;
      lV101Clinicawwds_25_tfclinicalinkedin = "" ;
      P008H2_A118ClinicaRUC = new long[1] ;
      P008H2_A28ClinicaId = new short[1] ;
      P008H2_A121ClinicaEstado = new String[] {""} ;
      P008H2_A120ClinicaTiempoDeCita = new byte[1] ;
      P008H2_A351ClinicaLinkedin = new String[] {""} ;
      P008H2_A350ClinicaInstagram = new String[] {""} ;
      P008H2_A349ClinicaTwiter = new String[] {""} ;
      P008H2_A348ClinicaFacebook = new String[] {""} ;
      P008H2_A347ClinicaWhatsApp = new String[] {""} ;
      P008H2_A346ClinicaTelefono = new String[] {""} ;
      P008H2_A341ClinicaMoneda = new short[1] ;
      P008H2_A340ClinicaCorreo = new String[] {""} ;
      P008H2_A119ClinicaDireccionComercial = new String[] {""} ;
      P008H2_A80ClinicaNombreAbreviado = new String[] {""} ;
      P008H2_A116ClinicaNombreComercial = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV47TFClinicaMoneda_SelsJson = "" ;
      AV62TFClinicaTiempoDeCita_SelsJson = "" ;
      AV65TFClinicaEstado_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.clinicawwexport__default(),
         new Object[] {
             new Object[] {
            P008H2_A118ClinicaRUC, P008H2_A28ClinicaId, P008H2_A121ClinicaEstado, P008H2_A120ClinicaTiempoDeCita, P008H2_A351ClinicaLinkedin, P008H2_A350ClinicaInstagram, P008H2_A349ClinicaTwiter, P008H2_A348ClinicaFacebook, P008H2_A347ClinicaWhatsApp, P008H2_A346ClinicaTelefono,
            P008H2_A341ClinicaMoneda, P008H2_A340ClinicaCorreo, P008H2_A119ClinicaDireccionComercial, P008H2_A80ClinicaNombreAbreviado, P008H2_A116ClinicaNombreComercial
            }
         }
      );
      AV71Pgmname = "ClinicaWWExport" ;
      /* GeneXus formulas. */
      AV71Pgmname = "ClinicaWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV64TFClinicaTiempoDeCita_Sel ;
   private byte A120ClinicaTiempoDeCita ;
   private short AV35TFClinicaId ;
   private short AV36TFClinicaId_To ;
   private short AV49TFClinicaMoneda_Sel ;
   private short GXv_int5[] ;
   private short A28ClinicaId ;
   private short A341ClinicaMoneda ;
   private short AV78Clinicawwds_2_tfclinicaid ;
   private short AV79Clinicawwds_3_tfclinicaid_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV72GXV1 ;
   private int AV73GXV2 ;
   private int AV74GXV3 ;
   private int AV75GXV4 ;
   private int AV90Clinicawwds_14_tfclinicamoneda_sels_size ;
   private int AV103Clinicawwds_27_tfclinicatiempodecita_sels_size ;
   private int AV104Clinicawwds_28_tfclinicaestado_sels_size ;
   private int AV105GXV5 ;
   private long AV37TFClinicaRUC ;
   private long AV38TFClinicaRUC_To ;
   private long AV68i ;
   private long AV32VisibleColumnCount ;
   private long A118ClinicaRUC ;
   private long AV80Clinicawwds_4_tfclinicaruc ;
   private long AV81Clinicawwds_5_tfclinicaruc_to ;
   private String AV71Pgmname ;
   private String AV51TFClinicaTelefono_Sel ;
   private String AV50TFClinicaTelefono ;
   private String AV53TFClinicaWhatsApp_Sel ;
   private String AV52TFClinicaWhatsApp ;
   private String AV67TFClinicaEstado_Sel ;
   private String A346ClinicaTelefono ;
   private String A347ClinicaWhatsApp ;
   private String A121ClinicaEstado ;
   private String AV91Clinicawwds_15_tfclinicatelefono ;
   private String AV92Clinicawwds_16_tfclinicatelefono_sel ;
   private String AV93Clinicawwds_17_tfclinicawhatsapp ;
   private String AV94Clinicawwds_18_tfclinicawhatsapp_sel ;
   private String scmdbuf ;
   private String lV91Clinicawwds_15_tfclinicatelefono ;
   private String lV93Clinicawwds_17_tfclinicawhatsapp ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV47TFClinicaMoneda_SelsJson ;
   private String AV62TFClinicaTiempoDeCita_SelsJson ;
   private String AV65TFClinicaEstado_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV40TFClinicaNombreComercial_Sel ;
   private String AV39TFClinicaNombreComercial ;
   private String AV42TFClinicaNombreAbreviado_Sel ;
   private String AV41TFClinicaNombreAbreviado ;
   private String AV44TFClinicaDireccionComercial_Sel ;
   private String AV43TFClinicaDireccionComercial ;
   private String AV46TFClinicaCorreo_Sel ;
   private String AV45TFClinicaCorreo ;
   private String AV55TFClinicaFacebook_Sel ;
   private String AV54TFClinicaFacebook ;
   private String AV57TFClinicaTwiter_Sel ;
   private String AV56TFClinicaTwiter ;
   private String AV59TFClinicaInstagram_Sel ;
   private String AV58TFClinicaInstagram ;
   private String AV61TFClinicaLinkedin_Sel ;
   private String AV60TFClinicaLinkedin ;
   private String A116ClinicaNombreComercial ;
   private String A80ClinicaNombreAbreviado ;
   private String A119ClinicaDireccionComercial ;
   private String A340ClinicaCorreo ;
   private String A348ClinicaFacebook ;
   private String A349ClinicaTwiter ;
   private String A350ClinicaInstagram ;
   private String A351ClinicaLinkedin ;
   private String AV77Clinicawwds_1_filterfulltext ;
   private String AV82Clinicawwds_6_tfclinicanombrecomercial ;
   private String AV83Clinicawwds_7_tfclinicanombrecomercial_sel ;
   private String AV84Clinicawwds_8_tfclinicanombreabreviado ;
   private String AV85Clinicawwds_9_tfclinicanombreabreviado_sel ;
   private String AV86Clinicawwds_10_tfclinicadireccioncomercial ;
   private String AV87Clinicawwds_11_tfclinicadireccioncomercial_sel ;
   private String AV88Clinicawwds_12_tfclinicacorreo ;
   private String AV89Clinicawwds_13_tfclinicacorreo_sel ;
   private String AV95Clinicawwds_19_tfclinicafacebook ;
   private String AV96Clinicawwds_20_tfclinicafacebook_sel ;
   private String AV97Clinicawwds_21_tfclinicatwiter ;
   private String AV98Clinicawwds_22_tfclinicatwiter_sel ;
   private String AV99Clinicawwds_23_tfclinicainstagram ;
   private String AV100Clinicawwds_24_tfclinicainstagram_sel ;
   private String AV101Clinicawwds_25_tfclinicalinkedin ;
   private String AV102Clinicawwds_26_tfclinicalinkedin_sel ;
   private String lV77Clinicawwds_1_filterfulltext ;
   private String lV82Clinicawwds_6_tfclinicanombrecomercial ;
   private String lV84Clinicawwds_8_tfclinicanombreabreviado ;
   private String lV86Clinicawwds_10_tfclinicadireccioncomercial ;
   private String lV88Clinicawwds_12_tfclinicacorreo ;
   private String lV95Clinicawwds_19_tfclinicafacebook ;
   private String lV97Clinicawwds_21_tfclinicatwiter ;
   private String lV99Clinicawwds_23_tfclinicainstagram ;
   private String lV101Clinicawwds_25_tfclinicalinkedin ;
   private GXSimpleCollection<Byte> AV63TFClinicaTiempoDeCita_Sels ;
   private GXSimpleCollection<Short> AV48TFClinicaMoneda_Sels ;
   private GXSimpleCollection<Byte> AV103Clinicawwds_27_tfclinicatiempodecita_sels ;
   private GXSimpleCollection<Short> AV90Clinicawwds_14_tfclinicamoneda_sels ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV66TFClinicaEstado_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P008H2_A118ClinicaRUC ;
   private short[] P008H2_A28ClinicaId ;
   private String[] P008H2_A121ClinicaEstado ;
   private byte[] P008H2_A120ClinicaTiempoDeCita ;
   private String[] P008H2_A351ClinicaLinkedin ;
   private String[] P008H2_A350ClinicaInstagram ;
   private String[] P008H2_A349ClinicaTwiter ;
   private String[] P008H2_A348ClinicaFacebook ;
   private String[] P008H2_A347ClinicaWhatsApp ;
   private String[] P008H2_A346ClinicaTelefono ;
   private short[] P008H2_A341ClinicaMoneda ;
   private String[] P008H2_A340ClinicaCorreo ;
   private String[] P008H2_A119ClinicaDireccionComercial ;
   private String[] P008H2_A80ClinicaNombreAbreviado ;
   private String[] P008H2_A116ClinicaNombreComercial ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV104Clinicawwds_28_tfclinicaestado_sels ;
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

final  class clinicawwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P008H2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short A341ClinicaMoneda ,
                                          GXSimpleCollection<Short> AV90Clinicawwds_14_tfclinicamoneda_sels ,
                                          byte A120ClinicaTiempoDeCita ,
                                          GXSimpleCollection<Byte> AV103Clinicawwds_27_tfclinicatiempodecita_sels ,
                                          String A121ClinicaEstado ,
                                          GXSimpleCollection<String> AV104Clinicawwds_28_tfclinicaestado_sels ,
                                          String AV77Clinicawwds_1_filterfulltext ,
                                          short AV78Clinicawwds_2_tfclinicaid ,
                                          short AV79Clinicawwds_3_tfclinicaid_to ,
                                          long AV80Clinicawwds_4_tfclinicaruc ,
                                          long AV81Clinicawwds_5_tfclinicaruc_to ,
                                          String AV83Clinicawwds_7_tfclinicanombrecomercial_sel ,
                                          String AV82Clinicawwds_6_tfclinicanombrecomercial ,
                                          String AV85Clinicawwds_9_tfclinicanombreabreviado_sel ,
                                          String AV84Clinicawwds_8_tfclinicanombreabreviado ,
                                          String AV87Clinicawwds_11_tfclinicadireccioncomercial_sel ,
                                          String AV86Clinicawwds_10_tfclinicadireccioncomercial ,
                                          String AV89Clinicawwds_13_tfclinicacorreo_sel ,
                                          String AV88Clinicawwds_12_tfclinicacorreo ,
                                          int AV90Clinicawwds_14_tfclinicamoneda_sels_size ,
                                          String AV92Clinicawwds_16_tfclinicatelefono_sel ,
                                          String AV91Clinicawwds_15_tfclinicatelefono ,
                                          String AV94Clinicawwds_18_tfclinicawhatsapp_sel ,
                                          String AV93Clinicawwds_17_tfclinicawhatsapp ,
                                          String AV96Clinicawwds_20_tfclinicafacebook_sel ,
                                          String AV95Clinicawwds_19_tfclinicafacebook ,
                                          String AV98Clinicawwds_22_tfclinicatwiter_sel ,
                                          String AV97Clinicawwds_21_tfclinicatwiter ,
                                          String AV100Clinicawwds_24_tfclinicainstagram_sel ,
                                          String AV99Clinicawwds_23_tfclinicainstagram ,
                                          String AV102Clinicawwds_26_tfclinicalinkedin_sel ,
                                          String AV101Clinicawwds_25_tfclinicalinkedin ,
                                          int AV103Clinicawwds_27_tfclinicatiempodecita_sels_size ,
                                          int AV104Clinicawwds_28_tfclinicaestado_sels_size ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A80ClinicaNombreAbreviado ,
                                          String A119ClinicaDireccionComercial ,
                                          String A340ClinicaCorreo ,
                                          String A346ClinicaTelefono ,
                                          String A347ClinicaWhatsApp ,
                                          String A348ClinicaFacebook ,
                                          String A349ClinicaTwiter ,
                                          String A350ClinicaInstagram ,
                                          String A351ClinicaLinkedin ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[43];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [ClinicaRUC], [ClinicaId], [ClinicaEstado], [ClinicaTiempoDeCita], [ClinicaLinkedin], [ClinicaInstagram], [ClinicaTwiter], [ClinicaFacebook], [ClinicaWhatsApp]," ;
      scmdbuf += " [ClinicaTelefono], [ClinicaMoneda], [ClinicaCorreo], [ClinicaDireccionComercial], [ClinicaNombreAbreviado], [ClinicaNombreComercial] FROM [Clinica]" ;
      if ( ! (GXutil.strcmp("", AV77Clinicawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST([ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( [ClinicaNombreComercial] like '%' + ?) or ( [ClinicaNombreAbreviado] like '%' + ?) or ( [ClinicaDireccionComercial] like '%' + ?) or ( [ClinicaCorreo] like '%' + ?) or ( 'soles' like '%' + LOWER(?) and [ClinicaMoneda] = 1) or ( 'dólares' like '%' + LOWER(?) and [ClinicaMoneda] = 2) or ( 'euros' like '%' + LOWER(?) and [ClinicaMoneda] = 3) or ( [ClinicaTelefono] like '%' + ?) or ( [ClinicaWhatsApp] like '%' + ?) or ( [ClinicaFacebook] like '%' + ?) or ( [ClinicaTwiter] like '%' + ?) or ( [ClinicaInstagram] like '%' + ?) or ( [ClinicaLinkedin] like '%' + ?) or ( '30 minutos' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 30) or ( '1 hora' like '%' + LOWER(?) and [ClinicaTiempoDeCita] = 60) or ( 'activo' like '%' + LOWER(?) and [ClinicaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [ClinicaEstado] = 'I'))");
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
         GXv_int10[10] = (byte)(1) ;
         GXv_int10[11] = (byte)(1) ;
         GXv_int10[12] = (byte)(1) ;
         GXv_int10[13] = (byte)(1) ;
         GXv_int10[14] = (byte)(1) ;
         GXv_int10[15] = (byte)(1) ;
         GXv_int10[16] = (byte)(1) ;
         GXv_int10[17] = (byte)(1) ;
         GXv_int10[18] = (byte)(1) ;
      }
      if ( ! (0==AV78Clinicawwds_2_tfclinicaid) )
      {
         addWhere(sWhereString, "([ClinicaId] >= ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( ! (0==AV79Clinicawwds_3_tfclinicaid_to) )
      {
         addWhere(sWhereString, "([ClinicaId] <= ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( ! (0==AV80Clinicawwds_4_tfclinicaruc) )
      {
         addWhere(sWhereString, "([ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      if ( ! (0==AV81Clinicawwds_5_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "([ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int10[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Clinicawwds_7_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV82Clinicawwds_6_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int10[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Clinicawwds_7_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int10[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV85Clinicawwds_9_tfclinicanombreabreviado_sel)==0) && ( ! (GXutil.strcmp("", AV84Clinicawwds_8_tfclinicanombreabreviado)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int10[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV85Clinicawwds_9_tfclinicanombreabreviado_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int10[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) && ( ! (GXutil.strcmp("", AV86Clinicawwds_10_tfclinicadireccioncomercial)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] like ?)");
      }
      else
      {
         GXv_int10[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Clinicawwds_11_tfclinicadireccioncomercial_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaDireccionComercial] = ?)");
      }
      else
      {
         GXv_int10[28] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV89Clinicawwds_13_tfclinicacorreo_sel)==0) && ( ! (GXutil.strcmp("", AV88Clinicawwds_12_tfclinicacorreo)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] like ?)");
      }
      else
      {
         GXv_int10[29] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV89Clinicawwds_13_tfclinicacorreo_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaCorreo] = ?)");
      }
      else
      {
         GXv_int10[30] = (byte)(1) ;
      }
      if ( AV90Clinicawwds_14_tfclinicamoneda_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV90Clinicawwds_14_tfclinicamoneda_sels, "[ClinicaMoneda] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV92Clinicawwds_16_tfclinicatelefono_sel)==0) && ( ! (GXutil.strcmp("", AV91Clinicawwds_15_tfclinicatelefono)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] like ?)");
      }
      else
      {
         GXv_int10[31] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV92Clinicawwds_16_tfclinicatelefono_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTelefono] = ?)");
      }
      else
      {
         GXv_int10[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV94Clinicawwds_18_tfclinicawhatsapp_sel)==0) && ( ! (GXutil.strcmp("", AV93Clinicawwds_17_tfclinicawhatsapp)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] like ?)");
      }
      else
      {
         GXv_int10[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV94Clinicawwds_18_tfclinicawhatsapp_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaWhatsApp] = ?)");
      }
      else
      {
         GXv_int10[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV96Clinicawwds_20_tfclinicafacebook_sel)==0) && ( ! (GXutil.strcmp("", AV95Clinicawwds_19_tfclinicafacebook)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] like ?)");
      }
      else
      {
         GXv_int10[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV96Clinicawwds_20_tfclinicafacebook_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaFacebook] = ?)");
      }
      else
      {
         GXv_int10[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV98Clinicawwds_22_tfclinicatwiter_sel)==0) && ( ! (GXutil.strcmp("", AV97Clinicawwds_21_tfclinicatwiter)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] like ?)");
      }
      else
      {
         GXv_int10[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV98Clinicawwds_22_tfclinicatwiter_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaTwiter] = ?)");
      }
      else
      {
         GXv_int10[38] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV100Clinicawwds_24_tfclinicainstagram_sel)==0) && ( ! (GXutil.strcmp("", AV99Clinicawwds_23_tfclinicainstagram)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] like ?)");
      }
      else
      {
         GXv_int10[39] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV100Clinicawwds_24_tfclinicainstagram_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaInstagram] = ?)");
      }
      else
      {
         GXv_int10[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV102Clinicawwds_26_tfclinicalinkedin_sel)==0) && ( ! (GXutil.strcmp("", AV101Clinicawwds_25_tfclinicalinkedin)==0) ) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] like ?)");
      }
      else
      {
         GXv_int10[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV102Clinicawwds_26_tfclinicalinkedin_sel)==0) )
      {
         addWhere(sWhereString, "([ClinicaLinkedin] = ?)");
      }
      else
      {
         GXv_int10[42] = (byte)(1) ;
      }
      if ( AV103Clinicawwds_27_tfclinicatiempodecita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV103Clinicawwds_27_tfclinicatiempodecita_sels, "[ClinicaTiempoDeCita] IN (", ")")+")");
      }
      if ( AV104Clinicawwds_28_tfclinicaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV104Clinicawwds_28_tfclinicaestado_sels, "[ClinicaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaRUC]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaRUC] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaNombreComercial]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaNombreComercial] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaNombreAbreviado]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaNombreAbreviado] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaDireccionComercial]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaDireccionComercial] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaCorreo]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaCorreo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaMoneda]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaMoneda] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaTelefono]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaTelefono] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaWhatsApp]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaWhatsApp] DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaFacebook]" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaFacebook] DESC" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaTwiter]" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaTwiter] DESC" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaInstagram]" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaInstagram] DESC" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaLinkedin]" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaLinkedin] DESC" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaTiempoDeCita]" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaTiempoDeCita] DESC" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [ClinicaEstado]" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [ClinicaEstado] DESC" ;
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
                  return conditional_P008H2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (GXSimpleCollection<Short>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).longValue() , ((Number) dynConstraints[10]).longValue() , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , (String)dynConstraints[27] , (String)dynConstraints[28] , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).longValue() , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , (String)dynConstraints[42] , (String)dynConstraints[43] , (String)dynConstraints[44] , (String)dynConstraints[45] , ((Number) dynConstraints[46]).shortValue() , ((Boolean) dynConstraints[47]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P008H2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 15);
               ((String[]) buf[9])[0] = rslt.getString(10, 12);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
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
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 1024);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 1024);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[74], 12);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[75], 12);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[76], 15);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[77], 15);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 1000);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 1000);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 1000);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 1000);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 1000);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 1000);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 1000);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 1000);
               }
               return;
      }
   }

}

