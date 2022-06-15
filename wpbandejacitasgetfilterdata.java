package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wpbandejacitasgetfilterdata extends GXProcedure
{
   public wpbandejacitasgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpbandejacitasgetfilterdata.class ), "" );
   }

   public wpbandejacitasgetfilterdata( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      wpbandejacitasgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      wpbandejacitasgetfilterdata.this.AV81DDOName = aP0;
      wpbandejacitasgetfilterdata.this.AV79SearchTxt = aP1;
      wpbandejacitasgetfilterdata.this.AV80SearchTxtTo = aP2;
      wpbandejacitasgetfilterdata.this.aP3 = aP3;
      wpbandejacitasgetfilterdata.this.aP4 = aP4;
      wpbandejacitasgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV84Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV87OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV89OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( GXutil.strcmp(GXutil.upper( AV81DDOName), "DDO_CITACODE") == 0 )
      {
         /* Execute user subroutine: 'LOADCITACODEOPTIONS' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV81DDOName), "DDO_PACIENTENRODOCUMENTO") == 0 )
      {
         /* Execute user subroutine: 'LOADPACIENTENRODOCUMENTOOPTIONS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV81DDOName), "DDO_PACIENTEAPELLIDOPATERNO") == 0 )
      {
         /* Execute user subroutine: 'LOADPACIENTEAPELLIDOPATERNOOPTIONS' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV81DDOName), "DDO_PACIENTEAPELLIDOMATERNO") == 0 )
      {
         /* Execute user subroutine: 'LOADPACIENTEAPELLIDOMATERNOOPTIONS' */
         S151 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV81DDOName), "DDO_PACIENTENOMBRES") == 0 )
      {
         /* Execute user subroutine: 'LOADPACIENTENOMBRESOPTIONS' */
         S161 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV81DDOName), "DDO_SGCITADISPONIBILIDADESPECIALIDADNOMBRE") == 0 )
      {
         /* Execute user subroutine: 'LOADSGCITADISPONIBILIDADESPECIALIDADNOMBREOPTIONS' */
         S171 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV81DDOName), "DDO_SGCITADISPONIBILIDADSEDENOMBRE") == 0 )
      {
         /* Execute user subroutine: 'LOADSGCITADISPONIBILIDADSEDENOMBREOPTIONS' */
         S181 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV81DDOName), "DDO_SGCITADISPONIBILIDADCLINICANOMBRE") == 0 )
      {
         /* Execute user subroutine: 'LOADSGCITADISPONIBILIDADCLINICANOMBREOPTIONS' */
         S191 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV81DDOName), "DDO_CITAARCHIVOEXTENCION") == 0 )
      {
         /* Execute user subroutine: 'LOADCITAARCHIVOEXTENCIONOPTIONS' */
         S201 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV85OptionsJson = AV84Options.toJSonString(false) ;
      AV88OptionsDescJson = AV87OptionsDesc.toJSonString(false) ;
      AV90OptionIndexesJson = AV89OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV92Session.getValue("WPBandejaCitasGridState"), "") == 0 )
      {
         AV94GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WPBandejaCitasGridState"), null, null);
      }
      else
      {
         AV94GridState.fromxml(AV92Session.getValue("WPBandejaCitasGridState"), null, null);
      }
      AV106GXV1 = 1 ;
      while ( AV106GXV1 <= AV94GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV95GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV94GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV106GXV1));
         if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV97FilterFullText = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV11TFCitaId = (int)(GXutil.lval( AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFCitaId_To = (int)(GXutil.lval( AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE") == 0 )
         {
            AV13TFCitaCode = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE_SEL") == 0 )
         {
            AV14TFCitaCode_Sel = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO") == 0 )
         {
            AV23TFPacienteNroDocumento = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO_SEL") == 0 )
         {
            AV24TFPacienteNroDocumento_Sel = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO") == 0 )
         {
            AV17TFPacienteApellidoPaterno = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO_SEL") == 0 )
         {
            AV18TFPacienteApellidoPaterno_Sel = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO") == 0 )
         {
            AV19TFPacienteApellidoMaterno = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO_SEL") == 0 )
         {
            AV20TFPacienteApellidoMaterno_Sel = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES") == 0 )
         {
            AV21TFPacienteNombres = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES_SEL") == 0 )
         {
            AV22TFPacienteNombres_Sel = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADFECHA") == 0 )
         {
            AV29TFSGCitaDisponibilidadFecha = localUtil.ctod( AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV30TFSGCitaDisponibilidadFecha_To = localUtil.ctod( AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADHORAINICIO") == 0 )
         {
            AV31TFSGCitaDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            AV32TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ctot( AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE") == 0 )
         {
            AV35TFSGCitaDisponibilidadEspecialidadNombre = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV36TFSGCitaDisponibilidadEspecialidadNombre_Sel = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADSEDENOMBRE") == 0 )
         {
            AV39TFSGCitaDisponibilidadSedeNombre = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADSEDENOMBRE_SEL") == 0 )
         {
            AV40TFSGCitaDisponibilidadSedeNombre_Sel = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE") == 0 )
         {
            AV43TFSGCitaDisponibilidadClinicaNombre = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE_SEL") == 0 )
         {
            AV44TFSGCitaDisponibilidadClinicaNombre_Sel = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAESTADOCITA_SEL") == 0 )
         {
            AV51TFCitaEstadoCita_SelsJson = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV52TFCitaEstadoCita_Sels.fromJSonString(AV51TFCitaEstadoCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAESTADOPAGO_SEL") == 0 )
         {
            AV73TFCitaEstadoPago_SelsJson = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV74TFCitaEstadoPago_Sels.fromJSonString(AV73TFCitaEstadoPago_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADHORAFIN") == 0 )
         {
            AV100TFSGCitaDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            AV101TFSGCitaDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ctot( AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAARCHIVOEXTENCION") == 0 )
         {
            AV102TFCitaArchivoExtencion = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAARCHIVOEXTENCION_SEL") == 0 )
         {
            AV103TFCitaArchivoExtencion_Sel = AV95GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV106GXV1 = (int)(AV106GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCITACODEOPTIONS' Routine */
      returnInSub = false ;
      AV13TFCitaCode = AV79SearchTxt ;
      AV14TFCitaCode_Sel = "" ;
      AV108Wpbandejacitasds_1_filterfulltext = AV97FilterFullText ;
      AV109Wpbandejacitasds_2_tfcitaid = AV11TFCitaId ;
      AV110Wpbandejacitasds_3_tfcitaid_to = AV12TFCitaId_To ;
      AV111Wpbandejacitasds_4_tfcitacode = AV13TFCitaCode ;
      AV112Wpbandejacitasds_5_tfcitacode_sel = AV14TFCitaCode_Sel ;
      AV113Wpbandejacitasds_6_tfpacientenrodocumento = AV23TFPacienteNroDocumento ;
      AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV24TFPacienteNroDocumento_Sel ;
      AV115Wpbandejacitasds_8_tfpacienteapellidopaterno = AV17TFPacienteApellidoPaterno ;
      AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV18TFPacienteApellidoPaterno_Sel ;
      AV117Wpbandejacitasds_10_tfpacienteapellidomaterno = AV19TFPacienteApellidoMaterno ;
      AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV20TFPacienteApellidoMaterno_Sel ;
      AV119Wpbandejacitasds_12_tfpacientenombres = AV21TFPacienteNombres ;
      AV120Wpbandejacitasds_13_tfpacientenombres_sel = AV22TFPacienteNombres_Sel ;
      AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV29TFSGCitaDisponibilidadFecha ;
      AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV30TFSGCitaDisponibilidadFecha_To ;
      AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV31TFSGCitaDisponibilidadHoraInicio ;
      AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV32TFSGCitaDisponibilidadHoraInicio_To ;
      AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV35TFSGCitaDisponibilidadEspecialidadNombre ;
      AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV36TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV39TFSGCitaDisponibilidadSedeNombre ;
      AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV40TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV43TFSGCitaDisponibilidadClinicaNombre ;
      AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV44TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV131Wpbandejacitasds_24_tfcitaestadocita_sels = AV52TFCitaEstadoCita_Sels ;
      AV132Wpbandejacitasds_25_tfcitaestadopago_sels = AV74TFCitaEstadoPago_Sels ;
      AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV100TFSGCitaDisponibilidadHoraFin ;
      AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV101TFSGCitaDisponibilidadHoraFin_To ;
      AV135Wpbandejacitasds_28_tfcitaarchivoextencion = AV102TFCitaArchivoExtencion ;
      AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV103TFCitaArchivoExtencion_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A89CitaEstadoCita ,
                                           AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                           A102CitaEstadoPago ,
                                           AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                           AV108Wpbandejacitasds_1_filterfulltext ,
                                           Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid) ,
                                           Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to) ,
                                           AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                           AV111Wpbandejacitasds_4_tfcitacode ,
                                           AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                           AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                           AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                           AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                           AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                           AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                           AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                           AV119Wpbandejacitasds_12_tfpacientenombres ,
                                           AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                           AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                           AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                           AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                           AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                           AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                           AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                           AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV131Wpbandejacitasds_24_tfcitaestadocita_sels.size()) ,
                                           Integer.valueOf(AV132Wpbandejacitasds_25_tfcitaestadopago_sels.size()) ,
                                           AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                           AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                           AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                           AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                           Short.valueOf(AV99SecRoleId) ,
                                           A64CitaCode ,
                                           A106PacienteNroDocumento ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           A73SGCitaDisponibilidadSedeNombre ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           Integer.valueOf(A19CitaId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A68SGCitaDisponibilidadHoraInicio ,
                                           A387SGCitaDisponibilidadHoraFin ,
                                           A333CitaArchivoExtencion ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           Integer.valueOf(AV98ProfesionalId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV111Wpbandejacitasds_4_tfcitacode = GXutil.concat( GXutil.rtrim( AV111Wpbandejacitasds_4_tfcitacode), "%", "") ;
      lV113Wpbandejacitasds_6_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV113Wpbandejacitasds_6_tfpacientenrodocumento), "%", "") ;
      lV115Wpbandejacitasds_8_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV115Wpbandejacitasds_8_tfpacienteapellidopaterno), "%", "") ;
      lV117Wpbandejacitasds_10_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV117Wpbandejacitasds_10_tfpacienteapellidomaterno), "%", "") ;
      lV119Wpbandejacitasds_12_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV119Wpbandejacitasds_12_tfpacientenombres), "%", "") ;
      lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = GXutil.concat( GXutil.rtrim( AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre), "%", "") ;
      lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV135Wpbandejacitasds_28_tfcitaarchivoextencion = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_28_tfcitaarchivoextencion), "%", "") ;
      /* Using cursor P003U2 */
      pr_default.execute(0, new Object[] {lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid), Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to), lV111Wpbandejacitasds_4_tfcitacode, AV112Wpbandejacitasds_5_tfcitacode_sel, lV113Wpbandejacitasds_6_tfpacientenrodocumento, AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel, lV115Wpbandejacitasds_8_tfpacienteapellidopaterno, AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel, lV117Wpbandejacitasds_10_tfpacienteapellidomaterno, AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel, lV119Wpbandejacitasds_12_tfpacientenombres, AV120Wpbandejacitasds_13_tfpacientenombres_sel, AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha, AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to, AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio, AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to, lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre, AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel, lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre, AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel, lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre, AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel, AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin, AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to, lV135Wpbandejacitasds_28_tfcitaarchivoextencion, AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel, Integer.valueOf(AV98ProfesionalId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk3U2 = false ;
         A20PacienteId = P003U2_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P003U2_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U2_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U2_A72SGCitaDisponibilidadSedeId[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U2_A76SGCitaDisponibilidadClinicaId[0] ;
         A64CitaCode = P003U2_A64CitaCode[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U2_A81SGCitaDisponibilidadProfesionalId[0] ;
         A333CitaArchivoExtencion = P003U2_A333CitaArchivoExtencion[0] ;
         n333CitaArchivoExtencion = P003U2_n333CitaArchivoExtencion[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U2_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U2_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U2_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U2_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U2_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003U2_A19CitaId[0] ;
         A102CitaEstadoPago = P003U2_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = P003U2_n102CitaEstadoPago[0] ;
         A89CitaEstadoCita = P003U2_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = P003U2_n89CitaEstadoCita[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U2_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U2_A73SGCitaDisponibilidadSedeNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A105PacienteNombres = P003U2_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P003U2_A103PacienteApellidoPaterno[0] ;
         A106PacienteNroDocumento = P003U2_A106PacienteNroDocumento[0] ;
         A105PacienteNombres = P003U2_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P003U2_A103PacienteApellidoPaterno[0] ;
         A106PacienteNroDocumento = P003U2_A106PacienteNroDocumento[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U2_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U2_A72SGCitaDisponibilidadSedeId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U2_A81SGCitaDisponibilidadProfesionalId[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U2_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U2_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U2_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U2_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U2_n66SGCitaDisponibilidadFecha[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U2_A76SGCitaDisponibilidadClinicaId[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U2_A73SGCitaDisponibilidadSedeNombre[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U2_A78SGCitaDisponibilidadClinicaNombre[0] ;
         AV91count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P003U2_A64CitaCode[0], A64CitaCode) == 0 ) )
         {
            brk3U2 = false ;
            A19CitaId = P003U2_A19CitaId[0] ;
            AV91count = (long)(AV91count+1) ;
            brk3U2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A64CitaCode)==0) )
         {
            AV83Option = A64CitaCode ;
            AV84Options.add(AV83Option, 0);
            AV89OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV91count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV84Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3U2 )
         {
            brk3U2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADPACIENTENRODOCUMENTOOPTIONS' Routine */
      returnInSub = false ;
      AV23TFPacienteNroDocumento = AV79SearchTxt ;
      AV24TFPacienteNroDocumento_Sel = "" ;
      AV108Wpbandejacitasds_1_filterfulltext = AV97FilterFullText ;
      AV109Wpbandejacitasds_2_tfcitaid = AV11TFCitaId ;
      AV110Wpbandejacitasds_3_tfcitaid_to = AV12TFCitaId_To ;
      AV111Wpbandejacitasds_4_tfcitacode = AV13TFCitaCode ;
      AV112Wpbandejacitasds_5_tfcitacode_sel = AV14TFCitaCode_Sel ;
      AV113Wpbandejacitasds_6_tfpacientenrodocumento = AV23TFPacienteNroDocumento ;
      AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV24TFPacienteNroDocumento_Sel ;
      AV115Wpbandejacitasds_8_tfpacienteapellidopaterno = AV17TFPacienteApellidoPaterno ;
      AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV18TFPacienteApellidoPaterno_Sel ;
      AV117Wpbandejacitasds_10_tfpacienteapellidomaterno = AV19TFPacienteApellidoMaterno ;
      AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV20TFPacienteApellidoMaterno_Sel ;
      AV119Wpbandejacitasds_12_tfpacientenombres = AV21TFPacienteNombres ;
      AV120Wpbandejacitasds_13_tfpacientenombres_sel = AV22TFPacienteNombres_Sel ;
      AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV29TFSGCitaDisponibilidadFecha ;
      AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV30TFSGCitaDisponibilidadFecha_To ;
      AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV31TFSGCitaDisponibilidadHoraInicio ;
      AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV32TFSGCitaDisponibilidadHoraInicio_To ;
      AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV35TFSGCitaDisponibilidadEspecialidadNombre ;
      AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV36TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV39TFSGCitaDisponibilidadSedeNombre ;
      AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV40TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV43TFSGCitaDisponibilidadClinicaNombre ;
      AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV44TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV131Wpbandejacitasds_24_tfcitaestadocita_sels = AV52TFCitaEstadoCita_Sels ;
      AV132Wpbandejacitasds_25_tfcitaestadopago_sels = AV74TFCitaEstadoPago_Sels ;
      AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV100TFSGCitaDisponibilidadHoraFin ;
      AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV101TFSGCitaDisponibilidadHoraFin_To ;
      AV135Wpbandejacitasds_28_tfcitaarchivoextencion = AV102TFCitaArchivoExtencion ;
      AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV103TFCitaArchivoExtencion_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A89CitaEstadoCita ,
                                           AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                           A102CitaEstadoPago ,
                                           AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                           AV108Wpbandejacitasds_1_filterfulltext ,
                                           Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid) ,
                                           Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to) ,
                                           AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                           AV111Wpbandejacitasds_4_tfcitacode ,
                                           AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                           AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                           AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                           AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                           AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                           AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                           AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                           AV119Wpbandejacitasds_12_tfpacientenombres ,
                                           AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                           AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                           AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                           AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                           AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                           AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                           AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                           AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV131Wpbandejacitasds_24_tfcitaestadocita_sels.size()) ,
                                           Integer.valueOf(AV132Wpbandejacitasds_25_tfcitaestadopago_sels.size()) ,
                                           AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                           AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                           AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                           AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                           Short.valueOf(AV99SecRoleId) ,
                                           A64CitaCode ,
                                           A106PacienteNroDocumento ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           A73SGCitaDisponibilidadSedeNombre ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           Integer.valueOf(A19CitaId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A68SGCitaDisponibilidadHoraInicio ,
                                           A387SGCitaDisponibilidadHoraFin ,
                                           A333CitaArchivoExtencion ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           Integer.valueOf(AV98ProfesionalId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV111Wpbandejacitasds_4_tfcitacode = GXutil.concat( GXutil.rtrim( AV111Wpbandejacitasds_4_tfcitacode), "%", "") ;
      lV113Wpbandejacitasds_6_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV113Wpbandejacitasds_6_tfpacientenrodocumento), "%", "") ;
      lV115Wpbandejacitasds_8_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV115Wpbandejacitasds_8_tfpacienteapellidopaterno), "%", "") ;
      lV117Wpbandejacitasds_10_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV117Wpbandejacitasds_10_tfpacienteapellidomaterno), "%", "") ;
      lV119Wpbandejacitasds_12_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV119Wpbandejacitasds_12_tfpacientenombres), "%", "") ;
      lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = GXutil.concat( GXutil.rtrim( AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre), "%", "") ;
      lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV135Wpbandejacitasds_28_tfcitaarchivoextencion = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_28_tfcitaarchivoextencion), "%", "") ;
      /* Using cursor P003U3 */
      pr_default.execute(1, new Object[] {lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid), Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to), lV111Wpbandejacitasds_4_tfcitacode, AV112Wpbandejacitasds_5_tfcitacode_sel, lV113Wpbandejacitasds_6_tfpacientenrodocumento, AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel, lV115Wpbandejacitasds_8_tfpacienteapellidopaterno, AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel, lV117Wpbandejacitasds_10_tfpacienteapellidomaterno, AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel, lV119Wpbandejacitasds_12_tfpacientenombres, AV120Wpbandejacitasds_13_tfpacientenombres_sel, AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha, AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to, AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio, AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to, lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre, AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel, lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre, AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel, lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre, AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel, AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin, AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to, lV135Wpbandejacitasds_28_tfcitaarchivoextencion, AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel, Integer.valueOf(AV98ProfesionalId)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk3U4 = false ;
         A20PacienteId = P003U3_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P003U3_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U3_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U3_A72SGCitaDisponibilidadSedeId[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U3_A76SGCitaDisponibilidadClinicaId[0] ;
         A106PacienteNroDocumento = P003U3_A106PacienteNroDocumento[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U3_A81SGCitaDisponibilidadProfesionalId[0] ;
         A333CitaArchivoExtencion = P003U3_A333CitaArchivoExtencion[0] ;
         n333CitaArchivoExtencion = P003U3_n333CitaArchivoExtencion[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U3_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U3_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U3_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U3_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U3_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U3_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003U3_A19CitaId[0] ;
         A102CitaEstadoPago = P003U3_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = P003U3_n102CitaEstadoPago[0] ;
         A89CitaEstadoCita = P003U3_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = P003U3_n89CitaEstadoCita[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U3_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U3_A73SGCitaDisponibilidadSedeNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U3_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A105PacienteNombres = P003U3_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U3_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P003U3_A103PacienteApellidoPaterno[0] ;
         A64CitaCode = P003U3_A64CitaCode[0] ;
         A106PacienteNroDocumento = P003U3_A106PacienteNroDocumento[0] ;
         A105PacienteNombres = P003U3_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U3_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P003U3_A103PacienteApellidoPaterno[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U3_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U3_A72SGCitaDisponibilidadSedeId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U3_A81SGCitaDisponibilidadProfesionalId[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U3_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U3_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U3_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U3_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U3_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U3_n66SGCitaDisponibilidadFecha[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U3_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U3_A76SGCitaDisponibilidadClinicaId[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U3_A73SGCitaDisponibilidadSedeNombre[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U3_A78SGCitaDisponibilidadClinicaNombre[0] ;
         AV91count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P003U3_A106PacienteNroDocumento[0], A106PacienteNroDocumento) == 0 ) )
         {
            brk3U4 = false ;
            A20PacienteId = P003U3_A20PacienteId[0] ;
            A19CitaId = P003U3_A19CitaId[0] ;
            AV91count = (long)(AV91count+1) ;
            brk3U4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A106PacienteNroDocumento)==0) )
         {
            AV83Option = A106PacienteNroDocumento ;
            AV84Options.add(AV83Option, 0);
            AV89OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV91count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV84Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3U4 )
         {
            brk3U4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADPACIENTEAPELLIDOPATERNOOPTIONS' Routine */
      returnInSub = false ;
      AV17TFPacienteApellidoPaterno = AV79SearchTxt ;
      AV18TFPacienteApellidoPaterno_Sel = "" ;
      AV108Wpbandejacitasds_1_filterfulltext = AV97FilterFullText ;
      AV109Wpbandejacitasds_2_tfcitaid = AV11TFCitaId ;
      AV110Wpbandejacitasds_3_tfcitaid_to = AV12TFCitaId_To ;
      AV111Wpbandejacitasds_4_tfcitacode = AV13TFCitaCode ;
      AV112Wpbandejacitasds_5_tfcitacode_sel = AV14TFCitaCode_Sel ;
      AV113Wpbandejacitasds_6_tfpacientenrodocumento = AV23TFPacienteNroDocumento ;
      AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV24TFPacienteNroDocumento_Sel ;
      AV115Wpbandejacitasds_8_tfpacienteapellidopaterno = AV17TFPacienteApellidoPaterno ;
      AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV18TFPacienteApellidoPaterno_Sel ;
      AV117Wpbandejacitasds_10_tfpacienteapellidomaterno = AV19TFPacienteApellidoMaterno ;
      AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV20TFPacienteApellidoMaterno_Sel ;
      AV119Wpbandejacitasds_12_tfpacientenombres = AV21TFPacienteNombres ;
      AV120Wpbandejacitasds_13_tfpacientenombres_sel = AV22TFPacienteNombres_Sel ;
      AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV29TFSGCitaDisponibilidadFecha ;
      AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV30TFSGCitaDisponibilidadFecha_To ;
      AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV31TFSGCitaDisponibilidadHoraInicio ;
      AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV32TFSGCitaDisponibilidadHoraInicio_To ;
      AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV35TFSGCitaDisponibilidadEspecialidadNombre ;
      AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV36TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV39TFSGCitaDisponibilidadSedeNombre ;
      AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV40TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV43TFSGCitaDisponibilidadClinicaNombre ;
      AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV44TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV131Wpbandejacitasds_24_tfcitaestadocita_sels = AV52TFCitaEstadoCita_Sels ;
      AV132Wpbandejacitasds_25_tfcitaestadopago_sels = AV74TFCitaEstadoPago_Sels ;
      AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV100TFSGCitaDisponibilidadHoraFin ;
      AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV101TFSGCitaDisponibilidadHoraFin_To ;
      AV135Wpbandejacitasds_28_tfcitaarchivoextencion = AV102TFCitaArchivoExtencion ;
      AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV103TFCitaArchivoExtencion_Sel ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A89CitaEstadoCita ,
                                           AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                           A102CitaEstadoPago ,
                                           AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                           AV108Wpbandejacitasds_1_filterfulltext ,
                                           Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid) ,
                                           Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to) ,
                                           AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                           AV111Wpbandejacitasds_4_tfcitacode ,
                                           AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                           AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                           AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                           AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                           AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                           AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                           AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                           AV119Wpbandejacitasds_12_tfpacientenombres ,
                                           AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                           AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                           AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                           AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                           AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                           AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                           AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                           AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV131Wpbandejacitasds_24_tfcitaestadocita_sels.size()) ,
                                           Integer.valueOf(AV132Wpbandejacitasds_25_tfcitaestadopago_sels.size()) ,
                                           AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                           AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                           AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                           AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                           Short.valueOf(AV99SecRoleId) ,
                                           A64CitaCode ,
                                           A106PacienteNroDocumento ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           A73SGCitaDisponibilidadSedeNombre ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           Integer.valueOf(A19CitaId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A68SGCitaDisponibilidadHoraInicio ,
                                           A387SGCitaDisponibilidadHoraFin ,
                                           A333CitaArchivoExtencion ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           Integer.valueOf(AV98ProfesionalId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV111Wpbandejacitasds_4_tfcitacode = GXutil.concat( GXutil.rtrim( AV111Wpbandejacitasds_4_tfcitacode), "%", "") ;
      lV113Wpbandejacitasds_6_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV113Wpbandejacitasds_6_tfpacientenrodocumento), "%", "") ;
      lV115Wpbandejacitasds_8_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV115Wpbandejacitasds_8_tfpacienteapellidopaterno), "%", "") ;
      lV117Wpbandejacitasds_10_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV117Wpbandejacitasds_10_tfpacienteapellidomaterno), "%", "") ;
      lV119Wpbandejacitasds_12_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV119Wpbandejacitasds_12_tfpacientenombres), "%", "") ;
      lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = GXutil.concat( GXutil.rtrim( AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre), "%", "") ;
      lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV135Wpbandejacitasds_28_tfcitaarchivoextencion = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_28_tfcitaarchivoextencion), "%", "") ;
      /* Using cursor P003U4 */
      pr_default.execute(2, new Object[] {lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid), Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to), lV111Wpbandejacitasds_4_tfcitacode, AV112Wpbandejacitasds_5_tfcitacode_sel, lV113Wpbandejacitasds_6_tfpacientenrodocumento, AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel, lV115Wpbandejacitasds_8_tfpacienteapellidopaterno, AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel, lV117Wpbandejacitasds_10_tfpacienteapellidomaterno, AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel, lV119Wpbandejacitasds_12_tfpacientenombres, AV120Wpbandejacitasds_13_tfpacientenombres_sel, AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha, AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to, AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio, AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to, lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre, AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel, lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre, AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel, lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre, AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel, AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin, AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to, lV135Wpbandejacitasds_28_tfcitaarchivoextencion, AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel, Integer.valueOf(AV98ProfesionalId)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk3U6 = false ;
         A20PacienteId = P003U4_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P003U4_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U4_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U4_A72SGCitaDisponibilidadSedeId[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U4_A76SGCitaDisponibilidadClinicaId[0] ;
         A103PacienteApellidoPaterno = P003U4_A103PacienteApellidoPaterno[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U4_A81SGCitaDisponibilidadProfesionalId[0] ;
         A333CitaArchivoExtencion = P003U4_A333CitaArchivoExtencion[0] ;
         n333CitaArchivoExtencion = P003U4_n333CitaArchivoExtencion[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U4_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U4_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U4_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U4_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U4_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U4_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003U4_A19CitaId[0] ;
         A102CitaEstadoPago = P003U4_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = P003U4_n102CitaEstadoPago[0] ;
         A89CitaEstadoCita = P003U4_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = P003U4_n89CitaEstadoCita[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U4_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U4_A73SGCitaDisponibilidadSedeNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U4_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A105PacienteNombres = P003U4_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U4_A104PacienteApellidoMaterno[0] ;
         A106PacienteNroDocumento = P003U4_A106PacienteNroDocumento[0] ;
         A64CitaCode = P003U4_A64CitaCode[0] ;
         A103PacienteApellidoPaterno = P003U4_A103PacienteApellidoPaterno[0] ;
         A105PacienteNombres = P003U4_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U4_A104PacienteApellidoMaterno[0] ;
         A106PacienteNroDocumento = P003U4_A106PacienteNroDocumento[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U4_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U4_A72SGCitaDisponibilidadSedeId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U4_A81SGCitaDisponibilidadProfesionalId[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U4_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U4_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U4_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U4_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U4_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U4_n66SGCitaDisponibilidadFecha[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U4_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U4_A76SGCitaDisponibilidadClinicaId[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U4_A73SGCitaDisponibilidadSedeNombre[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U4_A78SGCitaDisponibilidadClinicaNombre[0] ;
         AV91count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P003U4_A103PacienteApellidoPaterno[0], A103PacienteApellidoPaterno) == 0 ) )
         {
            brk3U6 = false ;
            A20PacienteId = P003U4_A20PacienteId[0] ;
            A19CitaId = P003U4_A19CitaId[0] ;
            AV91count = (long)(AV91count+1) ;
            brk3U6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A103PacienteApellidoPaterno)==0) )
         {
            AV83Option = A103PacienteApellidoPaterno ;
            AV84Options.add(AV83Option, 0);
            AV89OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV91count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV84Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3U6 )
         {
            brk3U6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADPACIENTEAPELLIDOMATERNOOPTIONS' Routine */
      returnInSub = false ;
      AV19TFPacienteApellidoMaterno = AV79SearchTxt ;
      AV20TFPacienteApellidoMaterno_Sel = "" ;
      AV108Wpbandejacitasds_1_filterfulltext = AV97FilterFullText ;
      AV109Wpbandejacitasds_2_tfcitaid = AV11TFCitaId ;
      AV110Wpbandejacitasds_3_tfcitaid_to = AV12TFCitaId_To ;
      AV111Wpbandejacitasds_4_tfcitacode = AV13TFCitaCode ;
      AV112Wpbandejacitasds_5_tfcitacode_sel = AV14TFCitaCode_Sel ;
      AV113Wpbandejacitasds_6_tfpacientenrodocumento = AV23TFPacienteNroDocumento ;
      AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV24TFPacienteNroDocumento_Sel ;
      AV115Wpbandejacitasds_8_tfpacienteapellidopaterno = AV17TFPacienteApellidoPaterno ;
      AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV18TFPacienteApellidoPaterno_Sel ;
      AV117Wpbandejacitasds_10_tfpacienteapellidomaterno = AV19TFPacienteApellidoMaterno ;
      AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV20TFPacienteApellidoMaterno_Sel ;
      AV119Wpbandejacitasds_12_tfpacientenombres = AV21TFPacienteNombres ;
      AV120Wpbandejacitasds_13_tfpacientenombres_sel = AV22TFPacienteNombres_Sel ;
      AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV29TFSGCitaDisponibilidadFecha ;
      AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV30TFSGCitaDisponibilidadFecha_To ;
      AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV31TFSGCitaDisponibilidadHoraInicio ;
      AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV32TFSGCitaDisponibilidadHoraInicio_To ;
      AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV35TFSGCitaDisponibilidadEspecialidadNombre ;
      AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV36TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV39TFSGCitaDisponibilidadSedeNombre ;
      AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV40TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV43TFSGCitaDisponibilidadClinicaNombre ;
      AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV44TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV131Wpbandejacitasds_24_tfcitaestadocita_sels = AV52TFCitaEstadoCita_Sels ;
      AV132Wpbandejacitasds_25_tfcitaestadopago_sels = AV74TFCitaEstadoPago_Sels ;
      AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV100TFSGCitaDisponibilidadHoraFin ;
      AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV101TFSGCitaDisponibilidadHoraFin_To ;
      AV135Wpbandejacitasds_28_tfcitaarchivoextencion = AV102TFCitaArchivoExtencion ;
      AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV103TFCitaArchivoExtencion_Sel ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A89CitaEstadoCita ,
                                           AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                           A102CitaEstadoPago ,
                                           AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                           AV108Wpbandejacitasds_1_filterfulltext ,
                                           Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid) ,
                                           Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to) ,
                                           AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                           AV111Wpbandejacitasds_4_tfcitacode ,
                                           AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                           AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                           AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                           AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                           AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                           AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                           AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                           AV119Wpbandejacitasds_12_tfpacientenombres ,
                                           AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                           AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                           AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                           AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                           AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                           AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                           AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                           AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV131Wpbandejacitasds_24_tfcitaestadocita_sels.size()) ,
                                           Integer.valueOf(AV132Wpbandejacitasds_25_tfcitaestadopago_sels.size()) ,
                                           AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                           AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                           AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                           AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                           Short.valueOf(AV99SecRoleId) ,
                                           A64CitaCode ,
                                           A106PacienteNroDocumento ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           A73SGCitaDisponibilidadSedeNombre ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           Integer.valueOf(A19CitaId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A68SGCitaDisponibilidadHoraInicio ,
                                           A387SGCitaDisponibilidadHoraFin ,
                                           A333CitaArchivoExtencion ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           Integer.valueOf(AV98ProfesionalId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV111Wpbandejacitasds_4_tfcitacode = GXutil.concat( GXutil.rtrim( AV111Wpbandejacitasds_4_tfcitacode), "%", "") ;
      lV113Wpbandejacitasds_6_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV113Wpbandejacitasds_6_tfpacientenrodocumento), "%", "") ;
      lV115Wpbandejacitasds_8_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV115Wpbandejacitasds_8_tfpacienteapellidopaterno), "%", "") ;
      lV117Wpbandejacitasds_10_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV117Wpbandejacitasds_10_tfpacienteapellidomaterno), "%", "") ;
      lV119Wpbandejacitasds_12_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV119Wpbandejacitasds_12_tfpacientenombres), "%", "") ;
      lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = GXutil.concat( GXutil.rtrim( AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre), "%", "") ;
      lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV135Wpbandejacitasds_28_tfcitaarchivoextencion = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_28_tfcitaarchivoextencion), "%", "") ;
      /* Using cursor P003U5 */
      pr_default.execute(3, new Object[] {lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid), Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to), lV111Wpbandejacitasds_4_tfcitacode, AV112Wpbandejacitasds_5_tfcitacode_sel, lV113Wpbandejacitasds_6_tfpacientenrodocumento, AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel, lV115Wpbandejacitasds_8_tfpacienteapellidopaterno, AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel, lV117Wpbandejacitasds_10_tfpacienteapellidomaterno, AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel, lV119Wpbandejacitasds_12_tfpacientenombres, AV120Wpbandejacitasds_13_tfpacientenombres_sel, AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha, AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to, AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio, AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to, lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre, AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel, lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre, AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel, lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre, AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel, AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin, AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to, lV135Wpbandejacitasds_28_tfcitaarchivoextencion, AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel, Integer.valueOf(AV98ProfesionalId)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk3U8 = false ;
         A20PacienteId = P003U5_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P003U5_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U5_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U5_A72SGCitaDisponibilidadSedeId[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U5_A76SGCitaDisponibilidadClinicaId[0] ;
         A104PacienteApellidoMaterno = P003U5_A104PacienteApellidoMaterno[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U5_A81SGCitaDisponibilidadProfesionalId[0] ;
         A333CitaArchivoExtencion = P003U5_A333CitaArchivoExtencion[0] ;
         n333CitaArchivoExtencion = P003U5_n333CitaArchivoExtencion[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U5_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U5_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U5_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U5_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U5_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U5_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003U5_A19CitaId[0] ;
         A102CitaEstadoPago = P003U5_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = P003U5_n102CitaEstadoPago[0] ;
         A89CitaEstadoCita = P003U5_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = P003U5_n89CitaEstadoCita[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U5_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U5_A73SGCitaDisponibilidadSedeNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U5_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A105PacienteNombres = P003U5_A105PacienteNombres[0] ;
         A103PacienteApellidoPaterno = P003U5_A103PacienteApellidoPaterno[0] ;
         A106PacienteNroDocumento = P003U5_A106PacienteNroDocumento[0] ;
         A64CitaCode = P003U5_A64CitaCode[0] ;
         A104PacienteApellidoMaterno = P003U5_A104PacienteApellidoMaterno[0] ;
         A105PacienteNombres = P003U5_A105PacienteNombres[0] ;
         A103PacienteApellidoPaterno = P003U5_A103PacienteApellidoPaterno[0] ;
         A106PacienteNroDocumento = P003U5_A106PacienteNroDocumento[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U5_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U5_A72SGCitaDisponibilidadSedeId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U5_A81SGCitaDisponibilidadProfesionalId[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U5_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U5_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U5_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U5_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U5_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U5_n66SGCitaDisponibilidadFecha[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U5_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U5_A76SGCitaDisponibilidadClinicaId[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U5_A73SGCitaDisponibilidadSedeNombre[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U5_A78SGCitaDisponibilidadClinicaNombre[0] ;
         AV91count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P003U5_A104PacienteApellidoMaterno[0], A104PacienteApellidoMaterno) == 0 ) )
         {
            brk3U8 = false ;
            A20PacienteId = P003U5_A20PacienteId[0] ;
            A19CitaId = P003U5_A19CitaId[0] ;
            AV91count = (long)(AV91count+1) ;
            brk3U8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A104PacienteApellidoMaterno)==0) )
         {
            AV83Option = A104PacienteApellidoMaterno ;
            AV84Options.add(AV83Option, 0);
            AV89OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV91count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV84Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3U8 )
         {
            brk3U8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADPACIENTENOMBRESOPTIONS' Routine */
      returnInSub = false ;
      AV21TFPacienteNombres = AV79SearchTxt ;
      AV22TFPacienteNombres_Sel = "" ;
      AV108Wpbandejacitasds_1_filterfulltext = AV97FilterFullText ;
      AV109Wpbandejacitasds_2_tfcitaid = AV11TFCitaId ;
      AV110Wpbandejacitasds_3_tfcitaid_to = AV12TFCitaId_To ;
      AV111Wpbandejacitasds_4_tfcitacode = AV13TFCitaCode ;
      AV112Wpbandejacitasds_5_tfcitacode_sel = AV14TFCitaCode_Sel ;
      AV113Wpbandejacitasds_6_tfpacientenrodocumento = AV23TFPacienteNroDocumento ;
      AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV24TFPacienteNroDocumento_Sel ;
      AV115Wpbandejacitasds_8_tfpacienteapellidopaterno = AV17TFPacienteApellidoPaterno ;
      AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV18TFPacienteApellidoPaterno_Sel ;
      AV117Wpbandejacitasds_10_tfpacienteapellidomaterno = AV19TFPacienteApellidoMaterno ;
      AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV20TFPacienteApellidoMaterno_Sel ;
      AV119Wpbandejacitasds_12_tfpacientenombres = AV21TFPacienteNombres ;
      AV120Wpbandejacitasds_13_tfpacientenombres_sel = AV22TFPacienteNombres_Sel ;
      AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV29TFSGCitaDisponibilidadFecha ;
      AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV30TFSGCitaDisponibilidadFecha_To ;
      AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV31TFSGCitaDisponibilidadHoraInicio ;
      AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV32TFSGCitaDisponibilidadHoraInicio_To ;
      AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV35TFSGCitaDisponibilidadEspecialidadNombre ;
      AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV36TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV39TFSGCitaDisponibilidadSedeNombre ;
      AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV40TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV43TFSGCitaDisponibilidadClinicaNombre ;
      AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV44TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV131Wpbandejacitasds_24_tfcitaestadocita_sels = AV52TFCitaEstadoCita_Sels ;
      AV132Wpbandejacitasds_25_tfcitaestadopago_sels = AV74TFCitaEstadoPago_Sels ;
      AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV100TFSGCitaDisponibilidadHoraFin ;
      AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV101TFSGCitaDisponibilidadHoraFin_To ;
      AV135Wpbandejacitasds_28_tfcitaarchivoextencion = AV102TFCitaArchivoExtencion ;
      AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV103TFCitaArchivoExtencion_Sel ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A89CitaEstadoCita ,
                                           AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                           A102CitaEstadoPago ,
                                           AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                           AV108Wpbandejacitasds_1_filterfulltext ,
                                           Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid) ,
                                           Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to) ,
                                           AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                           AV111Wpbandejacitasds_4_tfcitacode ,
                                           AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                           AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                           AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                           AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                           AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                           AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                           AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                           AV119Wpbandejacitasds_12_tfpacientenombres ,
                                           AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                           AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                           AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                           AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                           AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                           AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                           AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                           AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV131Wpbandejacitasds_24_tfcitaestadocita_sels.size()) ,
                                           Integer.valueOf(AV132Wpbandejacitasds_25_tfcitaestadopago_sels.size()) ,
                                           AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                           AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                           AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                           AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                           Short.valueOf(AV99SecRoleId) ,
                                           A64CitaCode ,
                                           A106PacienteNroDocumento ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           A73SGCitaDisponibilidadSedeNombre ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           Integer.valueOf(A19CitaId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A68SGCitaDisponibilidadHoraInicio ,
                                           A387SGCitaDisponibilidadHoraFin ,
                                           A333CitaArchivoExtencion ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           Integer.valueOf(AV98ProfesionalId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV111Wpbandejacitasds_4_tfcitacode = GXutil.concat( GXutil.rtrim( AV111Wpbandejacitasds_4_tfcitacode), "%", "") ;
      lV113Wpbandejacitasds_6_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV113Wpbandejacitasds_6_tfpacientenrodocumento), "%", "") ;
      lV115Wpbandejacitasds_8_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV115Wpbandejacitasds_8_tfpacienteapellidopaterno), "%", "") ;
      lV117Wpbandejacitasds_10_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV117Wpbandejacitasds_10_tfpacienteapellidomaterno), "%", "") ;
      lV119Wpbandejacitasds_12_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV119Wpbandejacitasds_12_tfpacientenombres), "%", "") ;
      lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = GXutil.concat( GXutil.rtrim( AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre), "%", "") ;
      lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV135Wpbandejacitasds_28_tfcitaarchivoextencion = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_28_tfcitaarchivoextencion), "%", "") ;
      /* Using cursor P003U6 */
      pr_default.execute(4, new Object[] {lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid), Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to), lV111Wpbandejacitasds_4_tfcitacode, AV112Wpbandejacitasds_5_tfcitacode_sel, lV113Wpbandejacitasds_6_tfpacientenrodocumento, AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel, lV115Wpbandejacitasds_8_tfpacienteapellidopaterno, AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel, lV117Wpbandejacitasds_10_tfpacienteapellidomaterno, AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel, lV119Wpbandejacitasds_12_tfpacientenombres, AV120Wpbandejacitasds_13_tfpacientenombres_sel, AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha, AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to, AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio, AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to, lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre, AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel, lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre, AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel, lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre, AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel, AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin, AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to, lV135Wpbandejacitasds_28_tfcitaarchivoextencion, AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel, Integer.valueOf(AV98ProfesionalId)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk3U10 = false ;
         A21SGCitaDisponibilidadId = P003U6_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U6_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U6_A72SGCitaDisponibilidadSedeId[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U6_A76SGCitaDisponibilidadClinicaId[0] ;
         A20PacienteId = P003U6_A20PacienteId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U6_A81SGCitaDisponibilidadProfesionalId[0] ;
         A333CitaArchivoExtencion = P003U6_A333CitaArchivoExtencion[0] ;
         n333CitaArchivoExtencion = P003U6_n333CitaArchivoExtencion[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U6_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U6_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U6_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U6_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U6_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U6_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003U6_A19CitaId[0] ;
         A102CitaEstadoPago = P003U6_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = P003U6_n102CitaEstadoPago[0] ;
         A89CitaEstadoCita = P003U6_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = P003U6_n89CitaEstadoCita[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U6_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U6_A73SGCitaDisponibilidadSedeNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U6_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A105PacienteNombres = P003U6_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U6_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P003U6_A103PacienteApellidoPaterno[0] ;
         A106PacienteNroDocumento = P003U6_A106PacienteNroDocumento[0] ;
         A64CitaCode = P003U6_A64CitaCode[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U6_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U6_A72SGCitaDisponibilidadSedeId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U6_A81SGCitaDisponibilidadProfesionalId[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U6_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U6_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U6_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U6_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U6_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U6_n66SGCitaDisponibilidadFecha[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U6_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U6_A76SGCitaDisponibilidadClinicaId[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U6_A73SGCitaDisponibilidadSedeNombre[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U6_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A105PacienteNombres = P003U6_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U6_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P003U6_A103PacienteApellidoPaterno[0] ;
         A106PacienteNroDocumento = P003U6_A106PacienteNroDocumento[0] ;
         AV91count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( P003U6_A20PacienteId[0] == A20PacienteId ) )
         {
            brk3U10 = false ;
            A19CitaId = P003U6_A19CitaId[0] ;
            AV91count = (long)(AV91count+1) ;
            brk3U10 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A105PacienteNombres)==0) )
         {
            AV83Option = A105PacienteNombres ;
            AV82InsertIndex = 1 ;
            while ( ( AV82InsertIndex <= AV84Options.size() ) && ( GXutil.strcmp((String)AV84Options.elementAt(-1+AV82InsertIndex), AV83Option) < 0 ) )
            {
               AV82InsertIndex = (int)(AV82InsertIndex+1) ;
            }
            AV84Options.add(AV83Option, AV82InsertIndex);
            AV89OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV91count), "Z,ZZZ,ZZZ,ZZ9")), AV82InsertIndex);
         }
         if ( AV84Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3U10 )
         {
            brk3U10 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   public void S171( )
   {
      /* 'LOADSGCITADISPONIBILIDADESPECIALIDADNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV35TFSGCitaDisponibilidadEspecialidadNombre = AV79SearchTxt ;
      AV36TFSGCitaDisponibilidadEspecialidadNombre_Sel = "" ;
      AV108Wpbandejacitasds_1_filterfulltext = AV97FilterFullText ;
      AV109Wpbandejacitasds_2_tfcitaid = AV11TFCitaId ;
      AV110Wpbandejacitasds_3_tfcitaid_to = AV12TFCitaId_To ;
      AV111Wpbandejacitasds_4_tfcitacode = AV13TFCitaCode ;
      AV112Wpbandejacitasds_5_tfcitacode_sel = AV14TFCitaCode_Sel ;
      AV113Wpbandejacitasds_6_tfpacientenrodocumento = AV23TFPacienteNroDocumento ;
      AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV24TFPacienteNroDocumento_Sel ;
      AV115Wpbandejacitasds_8_tfpacienteapellidopaterno = AV17TFPacienteApellidoPaterno ;
      AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV18TFPacienteApellidoPaterno_Sel ;
      AV117Wpbandejacitasds_10_tfpacienteapellidomaterno = AV19TFPacienteApellidoMaterno ;
      AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV20TFPacienteApellidoMaterno_Sel ;
      AV119Wpbandejacitasds_12_tfpacientenombres = AV21TFPacienteNombres ;
      AV120Wpbandejacitasds_13_tfpacientenombres_sel = AV22TFPacienteNombres_Sel ;
      AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV29TFSGCitaDisponibilidadFecha ;
      AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV30TFSGCitaDisponibilidadFecha_To ;
      AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV31TFSGCitaDisponibilidadHoraInicio ;
      AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV32TFSGCitaDisponibilidadHoraInicio_To ;
      AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV35TFSGCitaDisponibilidadEspecialidadNombre ;
      AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV36TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV39TFSGCitaDisponibilidadSedeNombre ;
      AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV40TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV43TFSGCitaDisponibilidadClinicaNombre ;
      AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV44TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV131Wpbandejacitasds_24_tfcitaestadocita_sels = AV52TFCitaEstadoCita_Sels ;
      AV132Wpbandejacitasds_25_tfcitaestadopago_sels = AV74TFCitaEstadoPago_Sels ;
      AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV100TFSGCitaDisponibilidadHoraFin ;
      AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV101TFSGCitaDisponibilidadHoraFin_To ;
      AV135Wpbandejacitasds_28_tfcitaarchivoextencion = AV102TFCitaArchivoExtencion ;
      AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV103TFCitaArchivoExtencion_Sel ;
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           A89CitaEstadoCita ,
                                           AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                           A102CitaEstadoPago ,
                                           AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                           AV108Wpbandejacitasds_1_filterfulltext ,
                                           Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid) ,
                                           Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to) ,
                                           AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                           AV111Wpbandejacitasds_4_tfcitacode ,
                                           AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                           AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                           AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                           AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                           AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                           AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                           AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                           AV119Wpbandejacitasds_12_tfpacientenombres ,
                                           AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                           AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                           AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                           AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                           AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                           AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                           AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                           AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV131Wpbandejacitasds_24_tfcitaestadocita_sels.size()) ,
                                           Integer.valueOf(AV132Wpbandejacitasds_25_tfcitaestadopago_sels.size()) ,
                                           AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                           AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                           AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                           AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                           Short.valueOf(AV99SecRoleId) ,
                                           A64CitaCode ,
                                           A106PacienteNroDocumento ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           A73SGCitaDisponibilidadSedeNombre ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           Integer.valueOf(A19CitaId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A68SGCitaDisponibilidadHoraInicio ,
                                           A387SGCitaDisponibilidadHoraFin ,
                                           A333CitaArchivoExtencion ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           Integer.valueOf(AV98ProfesionalId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV111Wpbandejacitasds_4_tfcitacode = GXutil.concat( GXutil.rtrim( AV111Wpbandejacitasds_4_tfcitacode), "%", "") ;
      lV113Wpbandejacitasds_6_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV113Wpbandejacitasds_6_tfpacientenrodocumento), "%", "") ;
      lV115Wpbandejacitasds_8_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV115Wpbandejacitasds_8_tfpacienteapellidopaterno), "%", "") ;
      lV117Wpbandejacitasds_10_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV117Wpbandejacitasds_10_tfpacienteapellidomaterno), "%", "") ;
      lV119Wpbandejacitasds_12_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV119Wpbandejacitasds_12_tfpacientenombres), "%", "") ;
      lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = GXutil.concat( GXutil.rtrim( AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre), "%", "") ;
      lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV135Wpbandejacitasds_28_tfcitaarchivoextencion = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_28_tfcitaarchivoextencion), "%", "") ;
      /* Using cursor P003U7 */
      pr_default.execute(5, new Object[] {lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid), Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to), lV111Wpbandejacitasds_4_tfcitacode, AV112Wpbandejacitasds_5_tfcitacode_sel, lV113Wpbandejacitasds_6_tfpacientenrodocumento, AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel, lV115Wpbandejacitasds_8_tfpacienteapellidopaterno, AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel, lV117Wpbandejacitasds_10_tfpacienteapellidomaterno, AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel, lV119Wpbandejacitasds_12_tfpacientenombres, AV120Wpbandejacitasds_13_tfpacientenombres_sel, AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha, AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to, AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio, AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to, lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre, AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel, lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre, AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel, lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre, AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel, AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin, AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to, lV135Wpbandejacitasds_28_tfcitaarchivoextencion, AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel, Integer.valueOf(AV98ProfesionalId)});
      while ( (pr_default.getStatus(5) != 101) )
      {
         brk3U12 = false ;
         A20PacienteId = P003U7_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P003U7_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U7_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U7_A72SGCitaDisponibilidadSedeId[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U7_A76SGCitaDisponibilidadClinicaId[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U7_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U7_A81SGCitaDisponibilidadProfesionalId[0] ;
         A333CitaArchivoExtencion = P003U7_A333CitaArchivoExtencion[0] ;
         n333CitaArchivoExtencion = P003U7_n333CitaArchivoExtencion[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U7_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U7_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U7_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U7_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U7_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U7_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003U7_A19CitaId[0] ;
         A102CitaEstadoPago = P003U7_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = P003U7_n102CitaEstadoPago[0] ;
         A89CitaEstadoCita = P003U7_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = P003U7_n89CitaEstadoCita[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U7_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U7_A73SGCitaDisponibilidadSedeNombre[0] ;
         A105PacienteNombres = P003U7_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U7_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P003U7_A103PacienteApellidoPaterno[0] ;
         A106PacienteNroDocumento = P003U7_A106PacienteNroDocumento[0] ;
         A64CitaCode = P003U7_A64CitaCode[0] ;
         A105PacienteNombres = P003U7_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U7_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P003U7_A103PacienteApellidoPaterno[0] ;
         A106PacienteNroDocumento = P003U7_A106PacienteNroDocumento[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U7_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U7_A72SGCitaDisponibilidadSedeId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U7_A81SGCitaDisponibilidadProfesionalId[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U7_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U7_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U7_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U7_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U7_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U7_n66SGCitaDisponibilidadFecha[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U7_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U7_A76SGCitaDisponibilidadClinicaId[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U7_A73SGCitaDisponibilidadSedeNombre[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U7_A78SGCitaDisponibilidadClinicaNombre[0] ;
         AV91count = 0 ;
         while ( (pr_default.getStatus(5) != 101) && ( GXutil.strcmp(P003U7_A146SGCitaDisponibilidadEspecialidadNombre[0], A146SGCitaDisponibilidadEspecialidadNombre) == 0 ) )
         {
            brk3U12 = false ;
            A21SGCitaDisponibilidadId = P003U7_A21SGCitaDisponibilidadId[0] ;
            A70SGCitaDisponibilidadEspecialidadId = P003U7_A70SGCitaDisponibilidadEspecialidadId[0] ;
            A19CitaId = P003U7_A19CitaId[0] ;
            A70SGCitaDisponibilidadEspecialidadId = P003U7_A70SGCitaDisponibilidadEspecialidadId[0] ;
            AV91count = (long)(AV91count+1) ;
            brk3U12 = true ;
            pr_default.readNext(5);
         }
         if ( ! (GXutil.strcmp("", A146SGCitaDisponibilidadEspecialidadNombre)==0) )
         {
            AV83Option = A146SGCitaDisponibilidadEspecialidadNombre ;
            AV84Options.add(AV83Option, 0);
            AV89OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV91count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV84Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3U12 )
         {
            brk3U12 = true ;
            pr_default.readNext(5);
         }
      }
      pr_default.close(5);
   }

   public void S181( )
   {
      /* 'LOADSGCITADISPONIBILIDADSEDENOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV39TFSGCitaDisponibilidadSedeNombre = AV79SearchTxt ;
      AV40TFSGCitaDisponibilidadSedeNombre_Sel = "" ;
      AV108Wpbandejacitasds_1_filterfulltext = AV97FilterFullText ;
      AV109Wpbandejacitasds_2_tfcitaid = AV11TFCitaId ;
      AV110Wpbandejacitasds_3_tfcitaid_to = AV12TFCitaId_To ;
      AV111Wpbandejacitasds_4_tfcitacode = AV13TFCitaCode ;
      AV112Wpbandejacitasds_5_tfcitacode_sel = AV14TFCitaCode_Sel ;
      AV113Wpbandejacitasds_6_tfpacientenrodocumento = AV23TFPacienteNroDocumento ;
      AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV24TFPacienteNroDocumento_Sel ;
      AV115Wpbandejacitasds_8_tfpacienteapellidopaterno = AV17TFPacienteApellidoPaterno ;
      AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV18TFPacienteApellidoPaterno_Sel ;
      AV117Wpbandejacitasds_10_tfpacienteapellidomaterno = AV19TFPacienteApellidoMaterno ;
      AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV20TFPacienteApellidoMaterno_Sel ;
      AV119Wpbandejacitasds_12_tfpacientenombres = AV21TFPacienteNombres ;
      AV120Wpbandejacitasds_13_tfpacientenombres_sel = AV22TFPacienteNombres_Sel ;
      AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV29TFSGCitaDisponibilidadFecha ;
      AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV30TFSGCitaDisponibilidadFecha_To ;
      AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV31TFSGCitaDisponibilidadHoraInicio ;
      AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV32TFSGCitaDisponibilidadHoraInicio_To ;
      AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV35TFSGCitaDisponibilidadEspecialidadNombre ;
      AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV36TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV39TFSGCitaDisponibilidadSedeNombre ;
      AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV40TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV43TFSGCitaDisponibilidadClinicaNombre ;
      AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV44TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV131Wpbandejacitasds_24_tfcitaestadocita_sels = AV52TFCitaEstadoCita_Sels ;
      AV132Wpbandejacitasds_25_tfcitaestadopago_sels = AV74TFCitaEstadoPago_Sels ;
      AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV100TFSGCitaDisponibilidadHoraFin ;
      AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV101TFSGCitaDisponibilidadHoraFin_To ;
      AV135Wpbandejacitasds_28_tfcitaarchivoextencion = AV102TFCitaArchivoExtencion ;
      AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV103TFCitaArchivoExtencion_Sel ;
      pr_default.dynParam(6, new Object[]{ new Object[]{
                                           A89CitaEstadoCita ,
                                           AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                           A102CitaEstadoPago ,
                                           AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                           AV108Wpbandejacitasds_1_filterfulltext ,
                                           Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid) ,
                                           Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to) ,
                                           AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                           AV111Wpbandejacitasds_4_tfcitacode ,
                                           AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                           AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                           AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                           AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                           AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                           AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                           AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                           AV119Wpbandejacitasds_12_tfpacientenombres ,
                                           AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                           AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                           AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                           AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                           AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                           AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                           AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                           AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV131Wpbandejacitasds_24_tfcitaestadocita_sels.size()) ,
                                           Integer.valueOf(AV132Wpbandejacitasds_25_tfcitaestadopago_sels.size()) ,
                                           AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                           AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                           AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                           AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                           Short.valueOf(AV99SecRoleId) ,
                                           A64CitaCode ,
                                           A106PacienteNroDocumento ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           A73SGCitaDisponibilidadSedeNombre ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           Integer.valueOf(A19CitaId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A68SGCitaDisponibilidadHoraInicio ,
                                           A387SGCitaDisponibilidadHoraFin ,
                                           A333CitaArchivoExtencion ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           Integer.valueOf(AV98ProfesionalId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV111Wpbandejacitasds_4_tfcitacode = GXutil.concat( GXutil.rtrim( AV111Wpbandejacitasds_4_tfcitacode), "%", "") ;
      lV113Wpbandejacitasds_6_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV113Wpbandejacitasds_6_tfpacientenrodocumento), "%", "") ;
      lV115Wpbandejacitasds_8_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV115Wpbandejacitasds_8_tfpacienteapellidopaterno), "%", "") ;
      lV117Wpbandejacitasds_10_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV117Wpbandejacitasds_10_tfpacienteapellidomaterno), "%", "") ;
      lV119Wpbandejacitasds_12_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV119Wpbandejacitasds_12_tfpacientenombres), "%", "") ;
      lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = GXutil.concat( GXutil.rtrim( AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre), "%", "") ;
      lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV135Wpbandejacitasds_28_tfcitaarchivoextencion = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_28_tfcitaarchivoextencion), "%", "") ;
      /* Using cursor P003U8 */
      pr_default.execute(6, new Object[] {lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid), Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to), lV111Wpbandejacitasds_4_tfcitacode, AV112Wpbandejacitasds_5_tfcitacode_sel, lV113Wpbandejacitasds_6_tfpacientenrodocumento, AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel, lV115Wpbandejacitasds_8_tfpacienteapellidopaterno, AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel, lV117Wpbandejacitasds_10_tfpacienteapellidomaterno, AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel, lV119Wpbandejacitasds_12_tfpacientenombres, AV120Wpbandejacitasds_13_tfpacientenombres_sel, AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha, AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to, AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio, AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to, lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre, AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel, lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre, AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel, lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre, AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel, AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin, AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to, lV135Wpbandejacitasds_28_tfcitaarchivoextencion, AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel, Integer.valueOf(AV98ProfesionalId)});
      while ( (pr_default.getStatus(6) != 101) )
      {
         brk3U14 = false ;
         A20PacienteId = P003U8_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P003U8_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U8_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U8_A72SGCitaDisponibilidadSedeId[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U8_A76SGCitaDisponibilidadClinicaId[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U8_A73SGCitaDisponibilidadSedeNombre[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U8_A81SGCitaDisponibilidadProfesionalId[0] ;
         A333CitaArchivoExtencion = P003U8_A333CitaArchivoExtencion[0] ;
         n333CitaArchivoExtencion = P003U8_n333CitaArchivoExtencion[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U8_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U8_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U8_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U8_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U8_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U8_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003U8_A19CitaId[0] ;
         A102CitaEstadoPago = P003U8_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = P003U8_n102CitaEstadoPago[0] ;
         A89CitaEstadoCita = P003U8_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = P003U8_n89CitaEstadoCita[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U8_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U8_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A105PacienteNombres = P003U8_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U8_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P003U8_A103PacienteApellidoPaterno[0] ;
         A106PacienteNroDocumento = P003U8_A106PacienteNroDocumento[0] ;
         A64CitaCode = P003U8_A64CitaCode[0] ;
         A105PacienteNombres = P003U8_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U8_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P003U8_A103PacienteApellidoPaterno[0] ;
         A106PacienteNroDocumento = P003U8_A106PacienteNroDocumento[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U8_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U8_A72SGCitaDisponibilidadSedeId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U8_A81SGCitaDisponibilidadProfesionalId[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U8_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U8_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U8_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U8_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U8_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U8_n66SGCitaDisponibilidadFecha[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U8_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U8_A76SGCitaDisponibilidadClinicaId[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U8_A73SGCitaDisponibilidadSedeNombre[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U8_A78SGCitaDisponibilidadClinicaNombre[0] ;
         AV91count = 0 ;
         while ( (pr_default.getStatus(6) != 101) && ( GXutil.strcmp(P003U8_A73SGCitaDisponibilidadSedeNombre[0], A73SGCitaDisponibilidadSedeNombre) == 0 ) )
         {
            brk3U14 = false ;
            A21SGCitaDisponibilidadId = P003U8_A21SGCitaDisponibilidadId[0] ;
            A72SGCitaDisponibilidadSedeId = P003U8_A72SGCitaDisponibilidadSedeId[0] ;
            A19CitaId = P003U8_A19CitaId[0] ;
            A72SGCitaDisponibilidadSedeId = P003U8_A72SGCitaDisponibilidadSedeId[0] ;
            AV91count = (long)(AV91count+1) ;
            brk3U14 = true ;
            pr_default.readNext(6);
         }
         if ( ! (GXutil.strcmp("", A73SGCitaDisponibilidadSedeNombre)==0) )
         {
            AV83Option = A73SGCitaDisponibilidadSedeNombre ;
            AV84Options.add(AV83Option, 0);
            AV89OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV91count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV84Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3U14 )
         {
            brk3U14 = true ;
            pr_default.readNext(6);
         }
      }
      pr_default.close(6);
   }

   public void S191( )
   {
      /* 'LOADSGCITADISPONIBILIDADCLINICANOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV43TFSGCitaDisponibilidadClinicaNombre = AV79SearchTxt ;
      AV44TFSGCitaDisponibilidadClinicaNombre_Sel = "" ;
      AV108Wpbandejacitasds_1_filterfulltext = AV97FilterFullText ;
      AV109Wpbandejacitasds_2_tfcitaid = AV11TFCitaId ;
      AV110Wpbandejacitasds_3_tfcitaid_to = AV12TFCitaId_To ;
      AV111Wpbandejacitasds_4_tfcitacode = AV13TFCitaCode ;
      AV112Wpbandejacitasds_5_tfcitacode_sel = AV14TFCitaCode_Sel ;
      AV113Wpbandejacitasds_6_tfpacientenrodocumento = AV23TFPacienteNroDocumento ;
      AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV24TFPacienteNroDocumento_Sel ;
      AV115Wpbandejacitasds_8_tfpacienteapellidopaterno = AV17TFPacienteApellidoPaterno ;
      AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV18TFPacienteApellidoPaterno_Sel ;
      AV117Wpbandejacitasds_10_tfpacienteapellidomaterno = AV19TFPacienteApellidoMaterno ;
      AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV20TFPacienteApellidoMaterno_Sel ;
      AV119Wpbandejacitasds_12_tfpacientenombres = AV21TFPacienteNombres ;
      AV120Wpbandejacitasds_13_tfpacientenombres_sel = AV22TFPacienteNombres_Sel ;
      AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV29TFSGCitaDisponibilidadFecha ;
      AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV30TFSGCitaDisponibilidadFecha_To ;
      AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV31TFSGCitaDisponibilidadHoraInicio ;
      AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV32TFSGCitaDisponibilidadHoraInicio_To ;
      AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV35TFSGCitaDisponibilidadEspecialidadNombre ;
      AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV36TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV39TFSGCitaDisponibilidadSedeNombre ;
      AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV40TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV43TFSGCitaDisponibilidadClinicaNombre ;
      AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV44TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV131Wpbandejacitasds_24_tfcitaestadocita_sels = AV52TFCitaEstadoCita_Sels ;
      AV132Wpbandejacitasds_25_tfcitaestadopago_sels = AV74TFCitaEstadoPago_Sels ;
      AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV100TFSGCitaDisponibilidadHoraFin ;
      AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV101TFSGCitaDisponibilidadHoraFin_To ;
      AV135Wpbandejacitasds_28_tfcitaarchivoextencion = AV102TFCitaArchivoExtencion ;
      AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV103TFCitaArchivoExtencion_Sel ;
      pr_default.dynParam(7, new Object[]{ new Object[]{
                                           A89CitaEstadoCita ,
                                           AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                           A102CitaEstadoPago ,
                                           AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                           AV108Wpbandejacitasds_1_filterfulltext ,
                                           Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid) ,
                                           Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to) ,
                                           AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                           AV111Wpbandejacitasds_4_tfcitacode ,
                                           AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                           AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                           AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                           AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                           AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                           AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                           AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                           AV119Wpbandejacitasds_12_tfpacientenombres ,
                                           AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                           AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                           AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                           AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                           AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                           AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                           AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                           AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV131Wpbandejacitasds_24_tfcitaestadocita_sels.size()) ,
                                           Integer.valueOf(AV132Wpbandejacitasds_25_tfcitaestadopago_sels.size()) ,
                                           AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                           AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                           AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                           AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                           Short.valueOf(AV99SecRoleId) ,
                                           A64CitaCode ,
                                           A106PacienteNroDocumento ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           A73SGCitaDisponibilidadSedeNombre ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           Integer.valueOf(A19CitaId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A68SGCitaDisponibilidadHoraInicio ,
                                           A387SGCitaDisponibilidadHoraFin ,
                                           A333CitaArchivoExtencion ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           Integer.valueOf(AV98ProfesionalId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV111Wpbandejacitasds_4_tfcitacode = GXutil.concat( GXutil.rtrim( AV111Wpbandejacitasds_4_tfcitacode), "%", "") ;
      lV113Wpbandejacitasds_6_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV113Wpbandejacitasds_6_tfpacientenrodocumento), "%", "") ;
      lV115Wpbandejacitasds_8_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV115Wpbandejacitasds_8_tfpacienteapellidopaterno), "%", "") ;
      lV117Wpbandejacitasds_10_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV117Wpbandejacitasds_10_tfpacienteapellidomaterno), "%", "") ;
      lV119Wpbandejacitasds_12_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV119Wpbandejacitasds_12_tfpacientenombres), "%", "") ;
      lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = GXutil.concat( GXutil.rtrim( AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre), "%", "") ;
      lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV135Wpbandejacitasds_28_tfcitaarchivoextencion = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_28_tfcitaarchivoextencion), "%", "") ;
      /* Using cursor P003U9 */
      pr_default.execute(7, new Object[] {lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid), Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to), lV111Wpbandejacitasds_4_tfcitacode, AV112Wpbandejacitasds_5_tfcitacode_sel, lV113Wpbandejacitasds_6_tfpacientenrodocumento, AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel, lV115Wpbandejacitasds_8_tfpacienteapellidopaterno, AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel, lV117Wpbandejacitasds_10_tfpacienteapellidomaterno, AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel, lV119Wpbandejacitasds_12_tfpacientenombres, AV120Wpbandejacitasds_13_tfpacientenombres_sel, AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha, AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to, AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio, AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to, lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre, AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel, lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre, AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel, lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre, AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel, AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin, AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to, lV135Wpbandejacitasds_28_tfcitaarchivoextencion, AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel, Integer.valueOf(AV98ProfesionalId)});
      while ( (pr_default.getStatus(7) != 101) )
      {
         brk3U16 = false ;
         A20PacienteId = P003U9_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P003U9_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U9_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U9_A72SGCitaDisponibilidadSedeId[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U9_A76SGCitaDisponibilidadClinicaId[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U9_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U9_A81SGCitaDisponibilidadProfesionalId[0] ;
         A333CitaArchivoExtencion = P003U9_A333CitaArchivoExtencion[0] ;
         n333CitaArchivoExtencion = P003U9_n333CitaArchivoExtencion[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U9_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U9_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U9_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U9_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U9_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U9_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003U9_A19CitaId[0] ;
         A102CitaEstadoPago = P003U9_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = P003U9_n102CitaEstadoPago[0] ;
         A89CitaEstadoCita = P003U9_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = P003U9_n89CitaEstadoCita[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U9_A73SGCitaDisponibilidadSedeNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U9_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A105PacienteNombres = P003U9_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U9_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P003U9_A103PacienteApellidoPaterno[0] ;
         A106PacienteNroDocumento = P003U9_A106PacienteNroDocumento[0] ;
         A64CitaCode = P003U9_A64CitaCode[0] ;
         A105PacienteNombres = P003U9_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U9_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P003U9_A103PacienteApellidoPaterno[0] ;
         A106PacienteNroDocumento = P003U9_A106PacienteNroDocumento[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U9_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U9_A72SGCitaDisponibilidadSedeId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U9_A81SGCitaDisponibilidadProfesionalId[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U9_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U9_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U9_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U9_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U9_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U9_n66SGCitaDisponibilidadFecha[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U9_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U9_A76SGCitaDisponibilidadClinicaId[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U9_A73SGCitaDisponibilidadSedeNombre[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U9_A78SGCitaDisponibilidadClinicaNombre[0] ;
         AV91count = 0 ;
         while ( (pr_default.getStatus(7) != 101) && ( GXutil.strcmp(P003U9_A78SGCitaDisponibilidadClinicaNombre[0], A78SGCitaDisponibilidadClinicaNombre) == 0 ) )
         {
            brk3U16 = false ;
            A21SGCitaDisponibilidadId = P003U9_A21SGCitaDisponibilidadId[0] ;
            A72SGCitaDisponibilidadSedeId = P003U9_A72SGCitaDisponibilidadSedeId[0] ;
            A76SGCitaDisponibilidadClinicaId = P003U9_A76SGCitaDisponibilidadClinicaId[0] ;
            A19CitaId = P003U9_A19CitaId[0] ;
            A72SGCitaDisponibilidadSedeId = P003U9_A72SGCitaDisponibilidadSedeId[0] ;
            A76SGCitaDisponibilidadClinicaId = P003U9_A76SGCitaDisponibilidadClinicaId[0] ;
            AV91count = (long)(AV91count+1) ;
            brk3U16 = true ;
            pr_default.readNext(7);
         }
         if ( ! (GXutil.strcmp("", A78SGCitaDisponibilidadClinicaNombre)==0) )
         {
            AV83Option = A78SGCitaDisponibilidadClinicaNombre ;
            AV84Options.add(AV83Option, 0);
            AV89OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV91count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV84Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3U16 )
         {
            brk3U16 = true ;
            pr_default.readNext(7);
         }
      }
      pr_default.close(7);
   }

   public void S201( )
   {
      /* 'LOADCITAARCHIVOEXTENCIONOPTIONS' Routine */
      returnInSub = false ;
      AV102TFCitaArchivoExtencion = AV79SearchTxt ;
      AV103TFCitaArchivoExtencion_Sel = "" ;
      AV108Wpbandejacitasds_1_filterfulltext = AV97FilterFullText ;
      AV109Wpbandejacitasds_2_tfcitaid = AV11TFCitaId ;
      AV110Wpbandejacitasds_3_tfcitaid_to = AV12TFCitaId_To ;
      AV111Wpbandejacitasds_4_tfcitacode = AV13TFCitaCode ;
      AV112Wpbandejacitasds_5_tfcitacode_sel = AV14TFCitaCode_Sel ;
      AV113Wpbandejacitasds_6_tfpacientenrodocumento = AV23TFPacienteNroDocumento ;
      AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV24TFPacienteNroDocumento_Sel ;
      AV115Wpbandejacitasds_8_tfpacienteapellidopaterno = AV17TFPacienteApellidoPaterno ;
      AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV18TFPacienteApellidoPaterno_Sel ;
      AV117Wpbandejacitasds_10_tfpacienteapellidomaterno = AV19TFPacienteApellidoMaterno ;
      AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV20TFPacienteApellidoMaterno_Sel ;
      AV119Wpbandejacitasds_12_tfpacientenombres = AV21TFPacienteNombres ;
      AV120Wpbandejacitasds_13_tfpacientenombres_sel = AV22TFPacienteNombres_Sel ;
      AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV29TFSGCitaDisponibilidadFecha ;
      AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV30TFSGCitaDisponibilidadFecha_To ;
      AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV31TFSGCitaDisponibilidadHoraInicio ;
      AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV32TFSGCitaDisponibilidadHoraInicio_To ;
      AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV35TFSGCitaDisponibilidadEspecialidadNombre ;
      AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV36TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV39TFSGCitaDisponibilidadSedeNombre ;
      AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV40TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV43TFSGCitaDisponibilidadClinicaNombre ;
      AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV44TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV131Wpbandejacitasds_24_tfcitaestadocita_sels = AV52TFCitaEstadoCita_Sels ;
      AV132Wpbandejacitasds_25_tfcitaestadopago_sels = AV74TFCitaEstadoPago_Sels ;
      AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV100TFSGCitaDisponibilidadHoraFin ;
      AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV101TFSGCitaDisponibilidadHoraFin_To ;
      AV135Wpbandejacitasds_28_tfcitaarchivoextencion = AV102TFCitaArchivoExtencion ;
      AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV103TFCitaArchivoExtencion_Sel ;
      pr_default.dynParam(8, new Object[]{ new Object[]{
                                           A89CitaEstadoCita ,
                                           AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                           A102CitaEstadoPago ,
                                           AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                           AV108Wpbandejacitasds_1_filterfulltext ,
                                           Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid) ,
                                           Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to) ,
                                           AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                           AV111Wpbandejacitasds_4_tfcitacode ,
                                           AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                           AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                           AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                           AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                           AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                           AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                           AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                           AV119Wpbandejacitasds_12_tfpacientenombres ,
                                           AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                           AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                           AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                           AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                           AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                           AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                           AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                           AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV131Wpbandejacitasds_24_tfcitaestadocita_sels.size()) ,
                                           Integer.valueOf(AV132Wpbandejacitasds_25_tfcitaestadopago_sels.size()) ,
                                           AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                           AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                           AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                           AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                           Short.valueOf(AV99SecRoleId) ,
                                           A64CitaCode ,
                                           A106PacienteNroDocumento ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           A73SGCitaDisponibilidadSedeNombre ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           Integer.valueOf(A19CitaId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A68SGCitaDisponibilidadHoraInicio ,
                                           A387SGCitaDisponibilidadHoraFin ,
                                           A333CitaArchivoExtencion ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           Integer.valueOf(AV98ProfesionalId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV108Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV108Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV111Wpbandejacitasds_4_tfcitacode = GXutil.concat( GXutil.rtrim( AV111Wpbandejacitasds_4_tfcitacode), "%", "") ;
      lV113Wpbandejacitasds_6_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV113Wpbandejacitasds_6_tfpacientenrodocumento), "%", "") ;
      lV115Wpbandejacitasds_8_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV115Wpbandejacitasds_8_tfpacienteapellidopaterno), "%", "") ;
      lV117Wpbandejacitasds_10_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV117Wpbandejacitasds_10_tfpacienteapellidomaterno), "%", "") ;
      lV119Wpbandejacitasds_12_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV119Wpbandejacitasds_12_tfpacientenombres), "%", "") ;
      lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = GXutil.concat( GXutil.rtrim( AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre), "%", "") ;
      lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV135Wpbandejacitasds_28_tfcitaarchivoextencion = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_28_tfcitaarchivoextencion), "%", "") ;
      /* Using cursor P003U10 */
      pr_default.execute(8, new Object[] {lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, lV108Wpbandejacitasds_1_filterfulltext, Integer.valueOf(AV109Wpbandejacitasds_2_tfcitaid), Integer.valueOf(AV110Wpbandejacitasds_3_tfcitaid_to), lV111Wpbandejacitasds_4_tfcitacode, AV112Wpbandejacitasds_5_tfcitacode_sel, lV113Wpbandejacitasds_6_tfpacientenrodocumento, AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel, lV115Wpbandejacitasds_8_tfpacienteapellidopaterno, AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel, lV117Wpbandejacitasds_10_tfpacienteapellidomaterno, AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel, lV119Wpbandejacitasds_12_tfpacientenombres, AV120Wpbandejacitasds_13_tfpacientenombres_sel, AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha, AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to, AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio, AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to, lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre, AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel, lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre, AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel, lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre, AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel, AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin, AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to, lV135Wpbandejacitasds_28_tfcitaarchivoextencion, AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel, Integer.valueOf(AV98ProfesionalId)});
      while ( (pr_default.getStatus(8) != 101) )
      {
         brk3U18 = false ;
         A20PacienteId = P003U10_A20PacienteId[0] ;
         A21SGCitaDisponibilidadId = P003U10_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U10_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U10_A72SGCitaDisponibilidadSedeId[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U10_A76SGCitaDisponibilidadClinicaId[0] ;
         A333CitaArchivoExtencion = P003U10_A333CitaArchivoExtencion[0] ;
         n333CitaArchivoExtencion = P003U10_n333CitaArchivoExtencion[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U10_A81SGCitaDisponibilidadProfesionalId[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U10_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U10_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U10_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U10_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U10_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U10_n66SGCitaDisponibilidadFecha[0] ;
         A19CitaId = P003U10_A19CitaId[0] ;
         A102CitaEstadoPago = P003U10_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = P003U10_n102CitaEstadoPago[0] ;
         A89CitaEstadoCita = P003U10_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = P003U10_n89CitaEstadoCita[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U10_A78SGCitaDisponibilidadClinicaNombre[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U10_A73SGCitaDisponibilidadSedeNombre[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U10_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A105PacienteNombres = P003U10_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U10_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P003U10_A103PacienteApellidoPaterno[0] ;
         A106PacienteNroDocumento = P003U10_A106PacienteNroDocumento[0] ;
         A64CitaCode = P003U10_A64CitaCode[0] ;
         A105PacienteNombres = P003U10_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P003U10_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P003U10_A103PacienteApellidoPaterno[0] ;
         A106PacienteNroDocumento = P003U10_A106PacienteNroDocumento[0] ;
         A70SGCitaDisponibilidadEspecialidadId = P003U10_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A72SGCitaDisponibilidadSedeId = P003U10_A72SGCitaDisponibilidadSedeId[0] ;
         A81SGCitaDisponibilidadProfesionalId = P003U10_A81SGCitaDisponibilidadProfesionalId[0] ;
         A387SGCitaDisponibilidadHoraFin = P003U10_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P003U10_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P003U10_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P003U10_n68SGCitaDisponibilidadHoraInicio[0] ;
         A66SGCitaDisponibilidadFecha = P003U10_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P003U10_n66SGCitaDisponibilidadFecha[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = P003U10_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         A76SGCitaDisponibilidadClinicaId = P003U10_A76SGCitaDisponibilidadClinicaId[0] ;
         A73SGCitaDisponibilidadSedeNombre = P003U10_A73SGCitaDisponibilidadSedeNombre[0] ;
         A78SGCitaDisponibilidadClinicaNombre = P003U10_A78SGCitaDisponibilidadClinicaNombre[0] ;
         AV91count = 0 ;
         while ( (pr_default.getStatus(8) != 101) && ( GXutil.strcmp(P003U10_A333CitaArchivoExtencion[0], A333CitaArchivoExtencion) == 0 ) )
         {
            brk3U18 = false ;
            A19CitaId = P003U10_A19CitaId[0] ;
            AV91count = (long)(AV91count+1) ;
            brk3U18 = true ;
            pr_default.readNext(8);
         }
         if ( ! (GXutil.strcmp("", A333CitaArchivoExtencion)==0) )
         {
            AV83Option = A333CitaArchivoExtencion ;
            AV84Options.add(AV83Option, 0);
            AV89OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV91count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV84Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk3U18 )
         {
            brk3U18 = true ;
            pr_default.readNext(8);
         }
      }
      pr_default.close(8);
   }

   protected void cleanup( )
   {
      this.aP3[0] = wpbandejacitasgetfilterdata.this.AV85OptionsJson;
      this.aP4[0] = wpbandejacitasgetfilterdata.this.AV88OptionsDescJson;
      this.aP5[0] = wpbandejacitasgetfilterdata.this.AV90OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV85OptionsJson = "" ;
      AV88OptionsDescJson = "" ;
      AV90OptionIndexesJson = "" ;
      AV84Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV87OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV89OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV92Session = httpContext.getWebSession();
      AV94GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV95GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV97FilterFullText = "" ;
      AV13TFCitaCode = "" ;
      AV14TFCitaCode_Sel = "" ;
      AV23TFPacienteNroDocumento = "" ;
      AV24TFPacienteNroDocumento_Sel = "" ;
      AV17TFPacienteApellidoPaterno = "" ;
      AV18TFPacienteApellidoPaterno_Sel = "" ;
      AV19TFPacienteApellidoMaterno = "" ;
      AV20TFPacienteApellidoMaterno_Sel = "" ;
      AV21TFPacienteNombres = "" ;
      AV22TFPacienteNombres_Sel = "" ;
      AV29TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      AV30TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      AV31TFSGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV32TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetTime( GXutil.nullDate() );
      AV35TFSGCitaDisponibilidadEspecialidadNombre = "" ;
      AV36TFSGCitaDisponibilidadEspecialidadNombre_Sel = "" ;
      AV39TFSGCitaDisponibilidadSedeNombre = "" ;
      AV40TFSGCitaDisponibilidadSedeNombre_Sel = "" ;
      AV43TFSGCitaDisponibilidadClinicaNombre = "" ;
      AV44TFSGCitaDisponibilidadClinicaNombre_Sel = "" ;
      AV51TFCitaEstadoCita_SelsJson = "" ;
      AV52TFCitaEstadoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV73TFCitaEstadoPago_SelsJson = "" ;
      AV74TFCitaEstadoPago_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV100TFSGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      AV101TFSGCitaDisponibilidadHoraFin_To = GXutil.resetTime( GXutil.nullDate() );
      AV102TFCitaArchivoExtencion = "" ;
      AV103TFCitaArchivoExtencion_Sel = "" ;
      A64CitaCode = "" ;
      AV108Wpbandejacitasds_1_filterfulltext = "" ;
      AV111Wpbandejacitasds_4_tfcitacode = "" ;
      AV112Wpbandejacitasds_5_tfcitacode_sel = "" ;
      AV113Wpbandejacitasds_6_tfpacientenrodocumento = "" ;
      AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel = "" ;
      AV115Wpbandejacitasds_8_tfpacienteapellidopaterno = "" ;
      AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = "" ;
      AV117Wpbandejacitasds_10_tfpacienteapellidomaterno = "" ;
      AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = "" ;
      AV119Wpbandejacitasds_12_tfpacientenombres = "" ;
      AV120Wpbandejacitasds_13_tfpacientenombres_sel = "" ;
      AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = GXutil.nullDate() ;
      AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = GXutil.nullDate() ;
      AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
      AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = GXutil.resetTime( GXutil.nullDate() );
      AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = "" ;
      AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = "" ;
      AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = "" ;
      AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = "" ;
      AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = "" ;
      AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = "" ;
      AV131Wpbandejacitasds_24_tfcitaestadocita_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV132Wpbandejacitasds_25_tfcitaestadopago_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
      AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = GXutil.resetTime( GXutil.nullDate() );
      AV135Wpbandejacitasds_28_tfcitaarchivoextencion = "" ;
      AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel = "" ;
      scmdbuf = "" ;
      lV108Wpbandejacitasds_1_filterfulltext = "" ;
      lV111Wpbandejacitasds_4_tfcitacode = "" ;
      lV113Wpbandejacitasds_6_tfpacientenrodocumento = "" ;
      lV115Wpbandejacitasds_8_tfpacienteapellidopaterno = "" ;
      lV117Wpbandejacitasds_10_tfpacienteapellidomaterno = "" ;
      lV119Wpbandejacitasds_12_tfpacientenombres = "" ;
      lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = "" ;
      lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = "" ;
      lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = "" ;
      lV135Wpbandejacitasds_28_tfcitaarchivoextencion = "" ;
      A89CitaEstadoCita = "" ;
      A102CitaEstadoPago = "" ;
      A106PacienteNroDocumento = "" ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A73SGCitaDisponibilidadSedeNombre = "" ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A68SGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A387SGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A333CitaArchivoExtencion = "" ;
      P003U2_A20PacienteId = new int[1] ;
      P003U2_A21SGCitaDisponibilidadId = new int[1] ;
      P003U2_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P003U2_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P003U2_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P003U2_A64CitaCode = new String[] {""} ;
      P003U2_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P003U2_A333CitaArchivoExtencion = new String[] {""} ;
      P003U2_n333CitaArchivoExtencion = new boolean[] {false} ;
      P003U2_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P003U2_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      P003U2_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P003U2_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      P003U2_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003U2_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003U2_A19CitaId = new int[1] ;
      P003U2_A102CitaEstadoPago = new String[] {""} ;
      P003U2_n102CitaEstadoPago = new boolean[] {false} ;
      P003U2_A89CitaEstadoCita = new String[] {""} ;
      P003U2_n89CitaEstadoCita = new boolean[] {false} ;
      P003U2_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P003U2_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      P003U2_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P003U2_A105PacienteNombres = new String[] {""} ;
      P003U2_A104PacienteApellidoMaterno = new String[] {""} ;
      P003U2_A103PacienteApellidoPaterno = new String[] {""} ;
      P003U2_A106PacienteNroDocumento = new String[] {""} ;
      AV83Option = "" ;
      P003U3_A20PacienteId = new int[1] ;
      P003U3_A21SGCitaDisponibilidadId = new int[1] ;
      P003U3_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P003U3_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P003U3_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P003U3_A106PacienteNroDocumento = new String[] {""} ;
      P003U3_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P003U3_A333CitaArchivoExtencion = new String[] {""} ;
      P003U3_n333CitaArchivoExtencion = new boolean[] {false} ;
      P003U3_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P003U3_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      P003U3_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P003U3_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      P003U3_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003U3_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003U3_A19CitaId = new int[1] ;
      P003U3_A102CitaEstadoPago = new String[] {""} ;
      P003U3_n102CitaEstadoPago = new boolean[] {false} ;
      P003U3_A89CitaEstadoCita = new String[] {""} ;
      P003U3_n89CitaEstadoCita = new boolean[] {false} ;
      P003U3_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P003U3_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      P003U3_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P003U3_A105PacienteNombres = new String[] {""} ;
      P003U3_A104PacienteApellidoMaterno = new String[] {""} ;
      P003U3_A103PacienteApellidoPaterno = new String[] {""} ;
      P003U3_A64CitaCode = new String[] {""} ;
      P003U4_A20PacienteId = new int[1] ;
      P003U4_A21SGCitaDisponibilidadId = new int[1] ;
      P003U4_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P003U4_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P003U4_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P003U4_A103PacienteApellidoPaterno = new String[] {""} ;
      P003U4_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P003U4_A333CitaArchivoExtencion = new String[] {""} ;
      P003U4_n333CitaArchivoExtencion = new boolean[] {false} ;
      P003U4_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P003U4_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      P003U4_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P003U4_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      P003U4_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003U4_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003U4_A19CitaId = new int[1] ;
      P003U4_A102CitaEstadoPago = new String[] {""} ;
      P003U4_n102CitaEstadoPago = new boolean[] {false} ;
      P003U4_A89CitaEstadoCita = new String[] {""} ;
      P003U4_n89CitaEstadoCita = new boolean[] {false} ;
      P003U4_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P003U4_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      P003U4_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P003U4_A105PacienteNombres = new String[] {""} ;
      P003U4_A104PacienteApellidoMaterno = new String[] {""} ;
      P003U4_A106PacienteNroDocumento = new String[] {""} ;
      P003U4_A64CitaCode = new String[] {""} ;
      P003U5_A20PacienteId = new int[1] ;
      P003U5_A21SGCitaDisponibilidadId = new int[1] ;
      P003U5_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P003U5_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P003U5_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P003U5_A104PacienteApellidoMaterno = new String[] {""} ;
      P003U5_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P003U5_A333CitaArchivoExtencion = new String[] {""} ;
      P003U5_n333CitaArchivoExtencion = new boolean[] {false} ;
      P003U5_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P003U5_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      P003U5_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P003U5_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      P003U5_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003U5_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003U5_A19CitaId = new int[1] ;
      P003U5_A102CitaEstadoPago = new String[] {""} ;
      P003U5_n102CitaEstadoPago = new boolean[] {false} ;
      P003U5_A89CitaEstadoCita = new String[] {""} ;
      P003U5_n89CitaEstadoCita = new boolean[] {false} ;
      P003U5_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P003U5_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      P003U5_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P003U5_A105PacienteNombres = new String[] {""} ;
      P003U5_A103PacienteApellidoPaterno = new String[] {""} ;
      P003U5_A106PacienteNroDocumento = new String[] {""} ;
      P003U5_A64CitaCode = new String[] {""} ;
      P003U6_A21SGCitaDisponibilidadId = new int[1] ;
      P003U6_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P003U6_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P003U6_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P003U6_A20PacienteId = new int[1] ;
      P003U6_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P003U6_A333CitaArchivoExtencion = new String[] {""} ;
      P003U6_n333CitaArchivoExtencion = new boolean[] {false} ;
      P003U6_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P003U6_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      P003U6_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P003U6_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      P003U6_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003U6_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003U6_A19CitaId = new int[1] ;
      P003U6_A102CitaEstadoPago = new String[] {""} ;
      P003U6_n102CitaEstadoPago = new boolean[] {false} ;
      P003U6_A89CitaEstadoCita = new String[] {""} ;
      P003U6_n89CitaEstadoCita = new boolean[] {false} ;
      P003U6_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P003U6_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      P003U6_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P003U6_A105PacienteNombres = new String[] {""} ;
      P003U6_A104PacienteApellidoMaterno = new String[] {""} ;
      P003U6_A103PacienteApellidoPaterno = new String[] {""} ;
      P003U6_A106PacienteNroDocumento = new String[] {""} ;
      P003U6_A64CitaCode = new String[] {""} ;
      P003U7_A20PacienteId = new int[1] ;
      P003U7_A21SGCitaDisponibilidadId = new int[1] ;
      P003U7_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P003U7_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P003U7_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P003U7_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P003U7_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P003U7_A333CitaArchivoExtencion = new String[] {""} ;
      P003U7_n333CitaArchivoExtencion = new boolean[] {false} ;
      P003U7_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P003U7_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      P003U7_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P003U7_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      P003U7_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003U7_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003U7_A19CitaId = new int[1] ;
      P003U7_A102CitaEstadoPago = new String[] {""} ;
      P003U7_n102CitaEstadoPago = new boolean[] {false} ;
      P003U7_A89CitaEstadoCita = new String[] {""} ;
      P003U7_n89CitaEstadoCita = new boolean[] {false} ;
      P003U7_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P003U7_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      P003U7_A105PacienteNombres = new String[] {""} ;
      P003U7_A104PacienteApellidoMaterno = new String[] {""} ;
      P003U7_A103PacienteApellidoPaterno = new String[] {""} ;
      P003U7_A106PacienteNroDocumento = new String[] {""} ;
      P003U7_A64CitaCode = new String[] {""} ;
      P003U8_A20PacienteId = new int[1] ;
      P003U8_A21SGCitaDisponibilidadId = new int[1] ;
      P003U8_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P003U8_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P003U8_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P003U8_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      P003U8_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P003U8_A333CitaArchivoExtencion = new String[] {""} ;
      P003U8_n333CitaArchivoExtencion = new boolean[] {false} ;
      P003U8_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P003U8_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      P003U8_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P003U8_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      P003U8_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003U8_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003U8_A19CitaId = new int[1] ;
      P003U8_A102CitaEstadoPago = new String[] {""} ;
      P003U8_n102CitaEstadoPago = new boolean[] {false} ;
      P003U8_A89CitaEstadoCita = new String[] {""} ;
      P003U8_n89CitaEstadoCita = new boolean[] {false} ;
      P003U8_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P003U8_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P003U8_A105PacienteNombres = new String[] {""} ;
      P003U8_A104PacienteApellidoMaterno = new String[] {""} ;
      P003U8_A103PacienteApellidoPaterno = new String[] {""} ;
      P003U8_A106PacienteNroDocumento = new String[] {""} ;
      P003U8_A64CitaCode = new String[] {""} ;
      P003U9_A20PacienteId = new int[1] ;
      P003U9_A21SGCitaDisponibilidadId = new int[1] ;
      P003U9_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P003U9_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P003U9_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P003U9_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P003U9_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P003U9_A333CitaArchivoExtencion = new String[] {""} ;
      P003U9_n333CitaArchivoExtencion = new boolean[] {false} ;
      P003U9_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P003U9_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      P003U9_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P003U9_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      P003U9_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003U9_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003U9_A19CitaId = new int[1] ;
      P003U9_A102CitaEstadoPago = new String[] {""} ;
      P003U9_n102CitaEstadoPago = new boolean[] {false} ;
      P003U9_A89CitaEstadoCita = new String[] {""} ;
      P003U9_n89CitaEstadoCita = new boolean[] {false} ;
      P003U9_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      P003U9_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P003U9_A105PacienteNombres = new String[] {""} ;
      P003U9_A104PacienteApellidoMaterno = new String[] {""} ;
      P003U9_A103PacienteApellidoPaterno = new String[] {""} ;
      P003U9_A106PacienteNroDocumento = new String[] {""} ;
      P003U9_A64CitaCode = new String[] {""} ;
      P003U10_A20PacienteId = new int[1] ;
      P003U10_A21SGCitaDisponibilidadId = new int[1] ;
      P003U10_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      P003U10_A72SGCitaDisponibilidadSedeId = new short[1] ;
      P003U10_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      P003U10_A333CitaArchivoExtencion = new String[] {""} ;
      P003U10_n333CitaArchivoExtencion = new boolean[] {false} ;
      P003U10_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P003U10_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P003U10_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      P003U10_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P003U10_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      P003U10_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P003U10_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      P003U10_A19CitaId = new int[1] ;
      P003U10_A102CitaEstadoPago = new String[] {""} ;
      P003U10_n102CitaEstadoPago = new boolean[] {false} ;
      P003U10_A89CitaEstadoCita = new String[] {""} ;
      P003U10_n89CitaEstadoCita = new boolean[] {false} ;
      P003U10_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      P003U10_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      P003U10_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      P003U10_A105PacienteNombres = new String[] {""} ;
      P003U10_A104PacienteApellidoMaterno = new String[] {""} ;
      P003U10_A103PacienteApellidoPaterno = new String[] {""} ;
      P003U10_A106PacienteNroDocumento = new String[] {""} ;
      P003U10_A64CitaCode = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wpbandejacitasgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P003U2_A20PacienteId, P003U2_A21SGCitaDisponibilidadId, P003U2_A70SGCitaDisponibilidadEspecialidadId, P003U2_A72SGCitaDisponibilidadSedeId, P003U2_A76SGCitaDisponibilidadClinicaId, P003U2_A64CitaCode, P003U2_A81SGCitaDisponibilidadProfesionalId, P003U2_A333CitaArchivoExtencion, P003U2_n333CitaArchivoExtencion, P003U2_A387SGCitaDisponibilidadHoraFin,
            P003U2_n387SGCitaDisponibilidadHoraFin, P003U2_A68SGCitaDisponibilidadHoraInicio, P003U2_n68SGCitaDisponibilidadHoraInicio, P003U2_A66SGCitaDisponibilidadFecha, P003U2_n66SGCitaDisponibilidadFecha, P003U2_A19CitaId, P003U2_A102CitaEstadoPago, P003U2_n102CitaEstadoPago, P003U2_A89CitaEstadoCita, P003U2_n89CitaEstadoCita,
            P003U2_A78SGCitaDisponibilidadClinicaNombre, P003U2_A73SGCitaDisponibilidadSedeNombre, P003U2_A146SGCitaDisponibilidadEspecialidadNombre, P003U2_A105PacienteNombres, P003U2_A104PacienteApellidoMaterno, P003U2_A103PacienteApellidoPaterno, P003U2_A106PacienteNroDocumento
            }
            , new Object[] {
            P003U3_A20PacienteId, P003U3_A21SGCitaDisponibilidadId, P003U3_A70SGCitaDisponibilidadEspecialidadId, P003U3_A72SGCitaDisponibilidadSedeId, P003U3_A76SGCitaDisponibilidadClinicaId, P003U3_A106PacienteNroDocumento, P003U3_A81SGCitaDisponibilidadProfesionalId, P003U3_A333CitaArchivoExtencion, P003U3_n333CitaArchivoExtencion, P003U3_A387SGCitaDisponibilidadHoraFin,
            P003U3_n387SGCitaDisponibilidadHoraFin, P003U3_A68SGCitaDisponibilidadHoraInicio, P003U3_n68SGCitaDisponibilidadHoraInicio, P003U3_A66SGCitaDisponibilidadFecha, P003U3_n66SGCitaDisponibilidadFecha, P003U3_A19CitaId, P003U3_A102CitaEstadoPago, P003U3_n102CitaEstadoPago, P003U3_A89CitaEstadoCita, P003U3_n89CitaEstadoCita,
            P003U3_A78SGCitaDisponibilidadClinicaNombre, P003U3_A73SGCitaDisponibilidadSedeNombre, P003U3_A146SGCitaDisponibilidadEspecialidadNombre, P003U3_A105PacienteNombres, P003U3_A104PacienteApellidoMaterno, P003U3_A103PacienteApellidoPaterno, P003U3_A64CitaCode
            }
            , new Object[] {
            P003U4_A20PacienteId, P003U4_A21SGCitaDisponibilidadId, P003U4_A70SGCitaDisponibilidadEspecialidadId, P003U4_A72SGCitaDisponibilidadSedeId, P003U4_A76SGCitaDisponibilidadClinicaId, P003U4_A103PacienteApellidoPaterno, P003U4_A81SGCitaDisponibilidadProfesionalId, P003U4_A333CitaArchivoExtencion, P003U4_n333CitaArchivoExtencion, P003U4_A387SGCitaDisponibilidadHoraFin,
            P003U4_n387SGCitaDisponibilidadHoraFin, P003U4_A68SGCitaDisponibilidadHoraInicio, P003U4_n68SGCitaDisponibilidadHoraInicio, P003U4_A66SGCitaDisponibilidadFecha, P003U4_n66SGCitaDisponibilidadFecha, P003U4_A19CitaId, P003U4_A102CitaEstadoPago, P003U4_n102CitaEstadoPago, P003U4_A89CitaEstadoCita, P003U4_n89CitaEstadoCita,
            P003U4_A78SGCitaDisponibilidadClinicaNombre, P003U4_A73SGCitaDisponibilidadSedeNombre, P003U4_A146SGCitaDisponibilidadEspecialidadNombre, P003U4_A105PacienteNombres, P003U4_A104PacienteApellidoMaterno, P003U4_A106PacienteNroDocumento, P003U4_A64CitaCode
            }
            , new Object[] {
            P003U5_A20PacienteId, P003U5_A21SGCitaDisponibilidadId, P003U5_A70SGCitaDisponibilidadEspecialidadId, P003U5_A72SGCitaDisponibilidadSedeId, P003U5_A76SGCitaDisponibilidadClinicaId, P003U5_A104PacienteApellidoMaterno, P003U5_A81SGCitaDisponibilidadProfesionalId, P003U5_A333CitaArchivoExtencion, P003U5_n333CitaArchivoExtencion, P003U5_A387SGCitaDisponibilidadHoraFin,
            P003U5_n387SGCitaDisponibilidadHoraFin, P003U5_A68SGCitaDisponibilidadHoraInicio, P003U5_n68SGCitaDisponibilidadHoraInicio, P003U5_A66SGCitaDisponibilidadFecha, P003U5_n66SGCitaDisponibilidadFecha, P003U5_A19CitaId, P003U5_A102CitaEstadoPago, P003U5_n102CitaEstadoPago, P003U5_A89CitaEstadoCita, P003U5_n89CitaEstadoCita,
            P003U5_A78SGCitaDisponibilidadClinicaNombre, P003U5_A73SGCitaDisponibilidadSedeNombre, P003U5_A146SGCitaDisponibilidadEspecialidadNombre, P003U5_A105PacienteNombres, P003U5_A103PacienteApellidoPaterno, P003U5_A106PacienteNroDocumento, P003U5_A64CitaCode
            }
            , new Object[] {
            P003U6_A21SGCitaDisponibilidadId, P003U6_A70SGCitaDisponibilidadEspecialidadId, P003U6_A72SGCitaDisponibilidadSedeId, P003U6_A76SGCitaDisponibilidadClinicaId, P003U6_A20PacienteId, P003U6_A81SGCitaDisponibilidadProfesionalId, P003U6_A333CitaArchivoExtencion, P003U6_n333CitaArchivoExtencion, P003U6_A387SGCitaDisponibilidadHoraFin, P003U6_n387SGCitaDisponibilidadHoraFin,
            P003U6_A68SGCitaDisponibilidadHoraInicio, P003U6_n68SGCitaDisponibilidadHoraInicio, P003U6_A66SGCitaDisponibilidadFecha, P003U6_n66SGCitaDisponibilidadFecha, P003U6_A19CitaId, P003U6_A102CitaEstadoPago, P003U6_n102CitaEstadoPago, P003U6_A89CitaEstadoCita, P003U6_n89CitaEstadoCita, P003U6_A78SGCitaDisponibilidadClinicaNombre,
            P003U6_A73SGCitaDisponibilidadSedeNombre, P003U6_A146SGCitaDisponibilidadEspecialidadNombre, P003U6_A105PacienteNombres, P003U6_A104PacienteApellidoMaterno, P003U6_A103PacienteApellidoPaterno, P003U6_A106PacienteNroDocumento, P003U6_A64CitaCode
            }
            , new Object[] {
            P003U7_A20PacienteId, P003U7_A21SGCitaDisponibilidadId, P003U7_A70SGCitaDisponibilidadEspecialidadId, P003U7_A72SGCitaDisponibilidadSedeId, P003U7_A76SGCitaDisponibilidadClinicaId, P003U7_A146SGCitaDisponibilidadEspecialidadNombre, P003U7_A81SGCitaDisponibilidadProfesionalId, P003U7_A333CitaArchivoExtencion, P003U7_n333CitaArchivoExtencion, P003U7_A387SGCitaDisponibilidadHoraFin,
            P003U7_n387SGCitaDisponibilidadHoraFin, P003U7_A68SGCitaDisponibilidadHoraInicio, P003U7_n68SGCitaDisponibilidadHoraInicio, P003U7_A66SGCitaDisponibilidadFecha, P003U7_n66SGCitaDisponibilidadFecha, P003U7_A19CitaId, P003U7_A102CitaEstadoPago, P003U7_n102CitaEstadoPago, P003U7_A89CitaEstadoCita, P003U7_n89CitaEstadoCita,
            P003U7_A78SGCitaDisponibilidadClinicaNombre, P003U7_A73SGCitaDisponibilidadSedeNombre, P003U7_A105PacienteNombres, P003U7_A104PacienteApellidoMaterno, P003U7_A103PacienteApellidoPaterno, P003U7_A106PacienteNroDocumento, P003U7_A64CitaCode
            }
            , new Object[] {
            P003U8_A20PacienteId, P003U8_A21SGCitaDisponibilidadId, P003U8_A70SGCitaDisponibilidadEspecialidadId, P003U8_A72SGCitaDisponibilidadSedeId, P003U8_A76SGCitaDisponibilidadClinicaId, P003U8_A73SGCitaDisponibilidadSedeNombre, P003U8_A81SGCitaDisponibilidadProfesionalId, P003U8_A333CitaArchivoExtencion, P003U8_n333CitaArchivoExtencion, P003U8_A387SGCitaDisponibilidadHoraFin,
            P003U8_n387SGCitaDisponibilidadHoraFin, P003U8_A68SGCitaDisponibilidadHoraInicio, P003U8_n68SGCitaDisponibilidadHoraInicio, P003U8_A66SGCitaDisponibilidadFecha, P003U8_n66SGCitaDisponibilidadFecha, P003U8_A19CitaId, P003U8_A102CitaEstadoPago, P003U8_n102CitaEstadoPago, P003U8_A89CitaEstadoCita, P003U8_n89CitaEstadoCita,
            P003U8_A78SGCitaDisponibilidadClinicaNombre, P003U8_A146SGCitaDisponibilidadEspecialidadNombre, P003U8_A105PacienteNombres, P003U8_A104PacienteApellidoMaterno, P003U8_A103PacienteApellidoPaterno, P003U8_A106PacienteNroDocumento, P003U8_A64CitaCode
            }
            , new Object[] {
            P003U9_A20PacienteId, P003U9_A21SGCitaDisponibilidadId, P003U9_A70SGCitaDisponibilidadEspecialidadId, P003U9_A72SGCitaDisponibilidadSedeId, P003U9_A76SGCitaDisponibilidadClinicaId, P003U9_A78SGCitaDisponibilidadClinicaNombre, P003U9_A81SGCitaDisponibilidadProfesionalId, P003U9_A333CitaArchivoExtencion, P003U9_n333CitaArchivoExtencion, P003U9_A387SGCitaDisponibilidadHoraFin,
            P003U9_n387SGCitaDisponibilidadHoraFin, P003U9_A68SGCitaDisponibilidadHoraInicio, P003U9_n68SGCitaDisponibilidadHoraInicio, P003U9_A66SGCitaDisponibilidadFecha, P003U9_n66SGCitaDisponibilidadFecha, P003U9_A19CitaId, P003U9_A102CitaEstadoPago, P003U9_n102CitaEstadoPago, P003U9_A89CitaEstadoCita, P003U9_n89CitaEstadoCita,
            P003U9_A73SGCitaDisponibilidadSedeNombre, P003U9_A146SGCitaDisponibilidadEspecialidadNombre, P003U9_A105PacienteNombres, P003U9_A104PacienteApellidoMaterno, P003U9_A103PacienteApellidoPaterno, P003U9_A106PacienteNroDocumento, P003U9_A64CitaCode
            }
            , new Object[] {
            P003U10_A20PacienteId, P003U10_A21SGCitaDisponibilidadId, P003U10_A70SGCitaDisponibilidadEspecialidadId, P003U10_A72SGCitaDisponibilidadSedeId, P003U10_A76SGCitaDisponibilidadClinicaId, P003U10_A333CitaArchivoExtencion, P003U10_n333CitaArchivoExtencion, P003U10_A81SGCitaDisponibilidadProfesionalId, P003U10_A387SGCitaDisponibilidadHoraFin, P003U10_n387SGCitaDisponibilidadHoraFin,
            P003U10_A68SGCitaDisponibilidadHoraInicio, P003U10_n68SGCitaDisponibilidadHoraInicio, P003U10_A66SGCitaDisponibilidadFecha, P003U10_n66SGCitaDisponibilidadFecha, P003U10_A19CitaId, P003U10_A102CitaEstadoPago, P003U10_n102CitaEstadoPago, P003U10_A89CitaEstadoCita, P003U10_n89CitaEstadoCita, P003U10_A78SGCitaDisponibilidadClinicaNombre,
            P003U10_A73SGCitaDisponibilidadSedeNombre, P003U10_A146SGCitaDisponibilidadEspecialidadNombre, P003U10_A105PacienteNombres, P003U10_A104PacienteApellidoMaterno, P003U10_A103PacienteApellidoPaterno, P003U10_A106PacienteNroDocumento, P003U10_A64CitaCode
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV99SecRoleId ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short A72SGCitaDisponibilidadSedeId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short Gx_err ;
   private int AV106GXV1 ;
   private int AV11TFCitaId ;
   private int AV12TFCitaId_To ;
   private int AV109Wpbandejacitasds_2_tfcitaid ;
   private int AV110Wpbandejacitasds_3_tfcitaid_to ;
   private int AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size ;
   private int AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size ;
   private int A19CitaId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int AV98ProfesionalId ;
   private int A20PacienteId ;
   private int A21SGCitaDisponibilidadId ;
   private int AV82InsertIndex ;
   private long AV91count ;
   private String scmdbuf ;
   private String A89CitaEstadoCita ;
   private String A102CitaEstadoPago ;
   private java.util.Date AV31TFSGCitaDisponibilidadHoraInicio ;
   private java.util.Date AV32TFSGCitaDisponibilidadHoraInicio_To ;
   private java.util.Date AV100TFSGCitaDisponibilidadHoraFin ;
   private java.util.Date AV101TFSGCitaDisponibilidadHoraFin_To ;
   private java.util.Date AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ;
   private java.util.Date AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ;
   private java.util.Date AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ;
   private java.util.Date AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ;
   private java.util.Date A68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date A387SGCitaDisponibilidadHoraFin ;
   private java.util.Date AV29TFSGCitaDisponibilidadFecha ;
   private java.util.Date AV30TFSGCitaDisponibilidadFecha_To ;
   private java.util.Date AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ;
   private java.util.Date AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private boolean returnInSub ;
   private boolean brk3U2 ;
   private boolean n333CitaArchivoExtencion ;
   private boolean n387SGCitaDisponibilidadHoraFin ;
   private boolean n68SGCitaDisponibilidadHoraInicio ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n102CitaEstadoPago ;
   private boolean n89CitaEstadoCita ;
   private boolean brk3U4 ;
   private boolean brk3U6 ;
   private boolean brk3U8 ;
   private boolean brk3U10 ;
   private boolean brk3U12 ;
   private boolean brk3U14 ;
   private boolean brk3U16 ;
   private boolean brk3U18 ;
   private String AV85OptionsJson ;
   private String AV88OptionsDescJson ;
   private String AV90OptionIndexesJson ;
   private String AV51TFCitaEstadoCita_SelsJson ;
   private String AV73TFCitaEstadoPago_SelsJson ;
   private String AV81DDOName ;
   private String AV79SearchTxt ;
   private String AV80SearchTxtTo ;
   private String AV97FilterFullText ;
   private String AV13TFCitaCode ;
   private String AV14TFCitaCode_Sel ;
   private String AV23TFPacienteNroDocumento ;
   private String AV24TFPacienteNroDocumento_Sel ;
   private String AV17TFPacienteApellidoPaterno ;
   private String AV18TFPacienteApellidoPaterno_Sel ;
   private String AV19TFPacienteApellidoMaterno ;
   private String AV20TFPacienteApellidoMaterno_Sel ;
   private String AV21TFPacienteNombres ;
   private String AV22TFPacienteNombres_Sel ;
   private String AV35TFSGCitaDisponibilidadEspecialidadNombre ;
   private String AV36TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
   private String AV39TFSGCitaDisponibilidadSedeNombre ;
   private String AV40TFSGCitaDisponibilidadSedeNombre_Sel ;
   private String AV43TFSGCitaDisponibilidadClinicaNombre ;
   private String AV44TFSGCitaDisponibilidadClinicaNombre_Sel ;
   private String AV102TFCitaArchivoExtencion ;
   private String AV103TFCitaArchivoExtencion_Sel ;
   private String A64CitaCode ;
   private String AV108Wpbandejacitasds_1_filterfulltext ;
   private String AV111Wpbandejacitasds_4_tfcitacode ;
   private String AV112Wpbandejacitasds_5_tfcitacode_sel ;
   private String AV113Wpbandejacitasds_6_tfpacientenrodocumento ;
   private String AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ;
   private String AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ;
   private String AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ;
   private String AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ;
   private String AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ;
   private String AV119Wpbandejacitasds_12_tfpacientenombres ;
   private String AV120Wpbandejacitasds_13_tfpacientenombres_sel ;
   private String AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ;
   private String AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ;
   private String AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ;
   private String AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ;
   private String AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ;
   private String AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ;
   private String AV135Wpbandejacitasds_28_tfcitaarchivoextencion ;
   private String AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ;
   private String lV108Wpbandejacitasds_1_filterfulltext ;
   private String lV111Wpbandejacitasds_4_tfcitacode ;
   private String lV113Wpbandejacitasds_6_tfpacientenrodocumento ;
   private String lV115Wpbandejacitasds_8_tfpacienteapellidopaterno ;
   private String lV117Wpbandejacitasds_10_tfpacienteapellidomaterno ;
   private String lV119Wpbandejacitasds_12_tfpacientenombres ;
   private String lV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ;
   private String lV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ;
   private String lV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ;
   private String lV135Wpbandejacitasds_28_tfcitaarchivoextencion ;
   private String A106PacienteNroDocumento ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String A73SGCitaDisponibilidadSedeNombre ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private String A333CitaArchivoExtencion ;
   private String AV83Option ;
   private com.genexus.webpanels.WebSession AV92Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P003U2_A20PacienteId ;
   private int[] P003U2_A21SGCitaDisponibilidadId ;
   private short[] P003U2_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] P003U2_A72SGCitaDisponibilidadSedeId ;
   private short[] P003U2_A76SGCitaDisponibilidadClinicaId ;
   private String[] P003U2_A64CitaCode ;
   private int[] P003U2_A81SGCitaDisponibilidadProfesionalId ;
   private String[] P003U2_A333CitaArchivoExtencion ;
   private boolean[] P003U2_n333CitaArchivoExtencion ;
   private java.util.Date[] P003U2_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] P003U2_n387SGCitaDisponibilidadHoraFin ;
   private java.util.Date[] P003U2_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] P003U2_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] P003U2_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003U2_n66SGCitaDisponibilidadFecha ;
   private int[] P003U2_A19CitaId ;
   private String[] P003U2_A102CitaEstadoPago ;
   private boolean[] P003U2_n102CitaEstadoPago ;
   private String[] P003U2_A89CitaEstadoCita ;
   private boolean[] P003U2_n89CitaEstadoCita ;
   private String[] P003U2_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P003U2_A73SGCitaDisponibilidadSedeNombre ;
   private String[] P003U2_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P003U2_A105PacienteNombres ;
   private String[] P003U2_A104PacienteApellidoMaterno ;
   private String[] P003U2_A103PacienteApellidoPaterno ;
   private String[] P003U2_A106PacienteNroDocumento ;
   private int[] P003U3_A20PacienteId ;
   private int[] P003U3_A21SGCitaDisponibilidadId ;
   private short[] P003U3_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] P003U3_A72SGCitaDisponibilidadSedeId ;
   private short[] P003U3_A76SGCitaDisponibilidadClinicaId ;
   private String[] P003U3_A106PacienteNroDocumento ;
   private int[] P003U3_A81SGCitaDisponibilidadProfesionalId ;
   private String[] P003U3_A333CitaArchivoExtencion ;
   private boolean[] P003U3_n333CitaArchivoExtencion ;
   private java.util.Date[] P003U3_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] P003U3_n387SGCitaDisponibilidadHoraFin ;
   private java.util.Date[] P003U3_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] P003U3_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] P003U3_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003U3_n66SGCitaDisponibilidadFecha ;
   private int[] P003U3_A19CitaId ;
   private String[] P003U3_A102CitaEstadoPago ;
   private boolean[] P003U3_n102CitaEstadoPago ;
   private String[] P003U3_A89CitaEstadoCita ;
   private boolean[] P003U3_n89CitaEstadoCita ;
   private String[] P003U3_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P003U3_A73SGCitaDisponibilidadSedeNombre ;
   private String[] P003U3_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P003U3_A105PacienteNombres ;
   private String[] P003U3_A104PacienteApellidoMaterno ;
   private String[] P003U3_A103PacienteApellidoPaterno ;
   private String[] P003U3_A64CitaCode ;
   private int[] P003U4_A20PacienteId ;
   private int[] P003U4_A21SGCitaDisponibilidadId ;
   private short[] P003U4_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] P003U4_A72SGCitaDisponibilidadSedeId ;
   private short[] P003U4_A76SGCitaDisponibilidadClinicaId ;
   private String[] P003U4_A103PacienteApellidoPaterno ;
   private int[] P003U4_A81SGCitaDisponibilidadProfesionalId ;
   private String[] P003U4_A333CitaArchivoExtencion ;
   private boolean[] P003U4_n333CitaArchivoExtencion ;
   private java.util.Date[] P003U4_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] P003U4_n387SGCitaDisponibilidadHoraFin ;
   private java.util.Date[] P003U4_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] P003U4_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] P003U4_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003U4_n66SGCitaDisponibilidadFecha ;
   private int[] P003U4_A19CitaId ;
   private String[] P003U4_A102CitaEstadoPago ;
   private boolean[] P003U4_n102CitaEstadoPago ;
   private String[] P003U4_A89CitaEstadoCita ;
   private boolean[] P003U4_n89CitaEstadoCita ;
   private String[] P003U4_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P003U4_A73SGCitaDisponibilidadSedeNombre ;
   private String[] P003U4_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P003U4_A105PacienteNombres ;
   private String[] P003U4_A104PacienteApellidoMaterno ;
   private String[] P003U4_A106PacienteNroDocumento ;
   private String[] P003U4_A64CitaCode ;
   private int[] P003U5_A20PacienteId ;
   private int[] P003U5_A21SGCitaDisponibilidadId ;
   private short[] P003U5_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] P003U5_A72SGCitaDisponibilidadSedeId ;
   private short[] P003U5_A76SGCitaDisponibilidadClinicaId ;
   private String[] P003U5_A104PacienteApellidoMaterno ;
   private int[] P003U5_A81SGCitaDisponibilidadProfesionalId ;
   private String[] P003U5_A333CitaArchivoExtencion ;
   private boolean[] P003U5_n333CitaArchivoExtencion ;
   private java.util.Date[] P003U5_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] P003U5_n387SGCitaDisponibilidadHoraFin ;
   private java.util.Date[] P003U5_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] P003U5_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] P003U5_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003U5_n66SGCitaDisponibilidadFecha ;
   private int[] P003U5_A19CitaId ;
   private String[] P003U5_A102CitaEstadoPago ;
   private boolean[] P003U5_n102CitaEstadoPago ;
   private String[] P003U5_A89CitaEstadoCita ;
   private boolean[] P003U5_n89CitaEstadoCita ;
   private String[] P003U5_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P003U5_A73SGCitaDisponibilidadSedeNombre ;
   private String[] P003U5_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P003U5_A105PacienteNombres ;
   private String[] P003U5_A103PacienteApellidoPaterno ;
   private String[] P003U5_A106PacienteNroDocumento ;
   private String[] P003U5_A64CitaCode ;
   private int[] P003U6_A21SGCitaDisponibilidadId ;
   private short[] P003U6_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] P003U6_A72SGCitaDisponibilidadSedeId ;
   private short[] P003U6_A76SGCitaDisponibilidadClinicaId ;
   private int[] P003U6_A20PacienteId ;
   private int[] P003U6_A81SGCitaDisponibilidadProfesionalId ;
   private String[] P003U6_A333CitaArchivoExtencion ;
   private boolean[] P003U6_n333CitaArchivoExtencion ;
   private java.util.Date[] P003U6_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] P003U6_n387SGCitaDisponibilidadHoraFin ;
   private java.util.Date[] P003U6_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] P003U6_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] P003U6_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003U6_n66SGCitaDisponibilidadFecha ;
   private int[] P003U6_A19CitaId ;
   private String[] P003U6_A102CitaEstadoPago ;
   private boolean[] P003U6_n102CitaEstadoPago ;
   private String[] P003U6_A89CitaEstadoCita ;
   private boolean[] P003U6_n89CitaEstadoCita ;
   private String[] P003U6_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P003U6_A73SGCitaDisponibilidadSedeNombre ;
   private String[] P003U6_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P003U6_A105PacienteNombres ;
   private String[] P003U6_A104PacienteApellidoMaterno ;
   private String[] P003U6_A103PacienteApellidoPaterno ;
   private String[] P003U6_A106PacienteNroDocumento ;
   private String[] P003U6_A64CitaCode ;
   private int[] P003U7_A20PacienteId ;
   private int[] P003U7_A21SGCitaDisponibilidadId ;
   private short[] P003U7_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] P003U7_A72SGCitaDisponibilidadSedeId ;
   private short[] P003U7_A76SGCitaDisponibilidadClinicaId ;
   private String[] P003U7_A146SGCitaDisponibilidadEspecialidadNombre ;
   private int[] P003U7_A81SGCitaDisponibilidadProfesionalId ;
   private String[] P003U7_A333CitaArchivoExtencion ;
   private boolean[] P003U7_n333CitaArchivoExtencion ;
   private java.util.Date[] P003U7_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] P003U7_n387SGCitaDisponibilidadHoraFin ;
   private java.util.Date[] P003U7_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] P003U7_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] P003U7_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003U7_n66SGCitaDisponibilidadFecha ;
   private int[] P003U7_A19CitaId ;
   private String[] P003U7_A102CitaEstadoPago ;
   private boolean[] P003U7_n102CitaEstadoPago ;
   private String[] P003U7_A89CitaEstadoCita ;
   private boolean[] P003U7_n89CitaEstadoCita ;
   private String[] P003U7_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P003U7_A73SGCitaDisponibilidadSedeNombre ;
   private String[] P003U7_A105PacienteNombres ;
   private String[] P003U7_A104PacienteApellidoMaterno ;
   private String[] P003U7_A103PacienteApellidoPaterno ;
   private String[] P003U7_A106PacienteNroDocumento ;
   private String[] P003U7_A64CitaCode ;
   private int[] P003U8_A20PacienteId ;
   private int[] P003U8_A21SGCitaDisponibilidadId ;
   private short[] P003U8_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] P003U8_A72SGCitaDisponibilidadSedeId ;
   private short[] P003U8_A76SGCitaDisponibilidadClinicaId ;
   private String[] P003U8_A73SGCitaDisponibilidadSedeNombre ;
   private int[] P003U8_A81SGCitaDisponibilidadProfesionalId ;
   private String[] P003U8_A333CitaArchivoExtencion ;
   private boolean[] P003U8_n333CitaArchivoExtencion ;
   private java.util.Date[] P003U8_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] P003U8_n387SGCitaDisponibilidadHoraFin ;
   private java.util.Date[] P003U8_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] P003U8_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] P003U8_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003U8_n66SGCitaDisponibilidadFecha ;
   private int[] P003U8_A19CitaId ;
   private String[] P003U8_A102CitaEstadoPago ;
   private boolean[] P003U8_n102CitaEstadoPago ;
   private String[] P003U8_A89CitaEstadoCita ;
   private boolean[] P003U8_n89CitaEstadoCita ;
   private String[] P003U8_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P003U8_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P003U8_A105PacienteNombres ;
   private String[] P003U8_A104PacienteApellidoMaterno ;
   private String[] P003U8_A103PacienteApellidoPaterno ;
   private String[] P003U8_A106PacienteNroDocumento ;
   private String[] P003U8_A64CitaCode ;
   private int[] P003U9_A20PacienteId ;
   private int[] P003U9_A21SGCitaDisponibilidadId ;
   private short[] P003U9_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] P003U9_A72SGCitaDisponibilidadSedeId ;
   private short[] P003U9_A76SGCitaDisponibilidadClinicaId ;
   private String[] P003U9_A78SGCitaDisponibilidadClinicaNombre ;
   private int[] P003U9_A81SGCitaDisponibilidadProfesionalId ;
   private String[] P003U9_A333CitaArchivoExtencion ;
   private boolean[] P003U9_n333CitaArchivoExtencion ;
   private java.util.Date[] P003U9_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] P003U9_n387SGCitaDisponibilidadHoraFin ;
   private java.util.Date[] P003U9_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] P003U9_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] P003U9_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003U9_n66SGCitaDisponibilidadFecha ;
   private int[] P003U9_A19CitaId ;
   private String[] P003U9_A102CitaEstadoPago ;
   private boolean[] P003U9_n102CitaEstadoPago ;
   private String[] P003U9_A89CitaEstadoCita ;
   private boolean[] P003U9_n89CitaEstadoCita ;
   private String[] P003U9_A73SGCitaDisponibilidadSedeNombre ;
   private String[] P003U9_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P003U9_A105PacienteNombres ;
   private String[] P003U9_A104PacienteApellidoMaterno ;
   private String[] P003U9_A103PacienteApellidoPaterno ;
   private String[] P003U9_A106PacienteNroDocumento ;
   private String[] P003U9_A64CitaCode ;
   private int[] P003U10_A20PacienteId ;
   private int[] P003U10_A21SGCitaDisponibilidadId ;
   private short[] P003U10_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] P003U10_A72SGCitaDisponibilidadSedeId ;
   private short[] P003U10_A76SGCitaDisponibilidadClinicaId ;
   private String[] P003U10_A333CitaArchivoExtencion ;
   private boolean[] P003U10_n333CitaArchivoExtencion ;
   private int[] P003U10_A81SGCitaDisponibilidadProfesionalId ;
   private java.util.Date[] P003U10_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] P003U10_n387SGCitaDisponibilidadHoraFin ;
   private java.util.Date[] P003U10_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] P003U10_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] P003U10_A66SGCitaDisponibilidadFecha ;
   private boolean[] P003U10_n66SGCitaDisponibilidadFecha ;
   private int[] P003U10_A19CitaId ;
   private String[] P003U10_A102CitaEstadoPago ;
   private boolean[] P003U10_n102CitaEstadoPago ;
   private String[] P003U10_A89CitaEstadoCita ;
   private boolean[] P003U10_n89CitaEstadoCita ;
   private String[] P003U10_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] P003U10_A73SGCitaDisponibilidadSedeNombre ;
   private String[] P003U10_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] P003U10_A105PacienteNombres ;
   private String[] P003U10_A104PacienteApellidoMaterno ;
   private String[] P003U10_A103PacienteApellidoPaterno ;
   private String[] P003U10_A106PacienteNroDocumento ;
   private String[] P003U10_A64CitaCode ;
   private GXSimpleCollection<String> AV52TFCitaEstadoCita_Sels ;
   private GXSimpleCollection<String> AV74TFCitaEstadoPago_Sels ;
   private GXSimpleCollection<String> AV131Wpbandejacitasds_24_tfcitaestadocita_sels ;
   private GXSimpleCollection<String> AV132Wpbandejacitasds_25_tfcitaestadopago_sels ;
   private GXSimpleCollection<String> AV84Options ;
   private GXSimpleCollection<String> AV87OptionsDesc ;
   private GXSimpleCollection<String> AV89OptionIndexes ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV94GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV95GridStateFilterValue ;
}

final  class wpbandejacitasgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003U2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A89CitaEstadoCita ,
                                          GXSimpleCollection<String> AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                          String A102CitaEstadoPago ,
                                          GXSimpleCollection<String> AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                          String AV108Wpbandejacitasds_1_filterfulltext ,
                                          int AV109Wpbandejacitasds_2_tfcitaid ,
                                          int AV110Wpbandejacitasds_3_tfcitaid_to ,
                                          String AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                          String AV111Wpbandejacitasds_4_tfcitacode ,
                                          String AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                          String AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                          String AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                          String AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                          String AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                          String AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                          String AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                          String AV119Wpbandejacitasds_12_tfpacientenombres ,
                                          java.util.Date AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                          java.util.Date AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                          java.util.Date AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                          String AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                          String AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                          String AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                          String AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                          int AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size ,
                                          int AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size ,
                                          java.util.Date AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                          java.util.Date AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                          String AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                          String AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                          short AV99SecRoleId ,
                                          String A64CitaCode ,
                                          String A106PacienteNroDocumento ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          String A73SGCitaDisponibilidadSedeNombre ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          int A19CitaId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A68SGCitaDisponibilidadHoraInicio ,
                                          java.util.Date A387SGCitaDisponibilidadHoraFin ,
                                          String A333CitaArchivoExtencion ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          int AV98ProfesionalId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int2 = new byte[44];
      Object[] GXv_Object3 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteId], T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T3.[SGSedeDisponibilidadSedeId]" ;
      scmdbuf += " AS SGCitaDisponibilidadSedeId, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T1.[CitaCode], T3.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T1.[CitaArchivoExtencion]," ;
      scmdbuf += " T3.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T3.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha," ;
      scmdbuf += " T1.[CitaId], T1.[CitaEstadoPago], T1.[CitaEstadoCita], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T5.[SedeNombre] AS SGCitaDisponibilidadSedeNombre," ;
      scmdbuf += " T4.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T2.[PacienteNombres], T2.[PacienteApellidoMaterno], T2.[PacienteApellidoPaterno], T2.[PacienteNroDocumento]" ;
      scmdbuf += " FROM ((((([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId])" ;
      scmdbuf += " INNER JOIN [Especialidad] T4 ON T4.[EspecialidadId] = T3.[EspecialidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica]" ;
      scmdbuf += " T6 ON T6.[ClinicaId] = T5.[ClinicaId])" ;
      if ( ! (GXutil.strcmp("", AV108Wpbandejacitasds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[CitaCode] like '%' + ?) or ( T2.[PacienteNroDocumento] like '%' + ?) or ( T2.[PacienteApellidoPaterno] like '%' + ?) or ( T2.[PacienteApellidoMaterno] like '%' + ?) or ( T2.[PacienteNombres] like '%' + ?) or ( T4.[EspecialidadNombre] like '%' + ?) or ( T5.[SedeNombre] like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( 'sin pago' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'S') or ( 'pendiente' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'P') or ( 'pagado' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'G'))");
      }
      else
      {
         GXv_int2[0] = (byte)(1) ;
         GXv_int2[1] = (byte)(1) ;
         GXv_int2[2] = (byte)(1) ;
         GXv_int2[3] = (byte)(1) ;
         GXv_int2[4] = (byte)(1) ;
         GXv_int2[5] = (byte)(1) ;
         GXv_int2[6] = (byte)(1) ;
         GXv_int2[7] = (byte)(1) ;
         GXv_int2[8] = (byte)(1) ;
         GXv_int2[9] = (byte)(1) ;
         GXv_int2[10] = (byte)(1) ;
         GXv_int2[11] = (byte)(1) ;
         GXv_int2[12] = (byte)(1) ;
         GXv_int2[13] = (byte)(1) ;
         GXv_int2[14] = (byte)(1) ;
         GXv_int2[15] = (byte)(1) ;
         GXv_int2[16] = (byte)(1) ;
      }
      if ( ! (0==AV109Wpbandejacitasds_2_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int2[17] = (byte)(1) ;
      }
      if ( ! (0==AV110Wpbandejacitasds_3_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int2[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV111Wpbandejacitasds_4_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] like ?)");
      }
      else
      {
         GXv_int2[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] = ?)");
      }
      else
      {
         GXv_int2[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV113Wpbandejacitasds_6_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int2[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int2[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV115Wpbandejacitasds_8_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int2[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int2[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV117Wpbandejacitasds_10_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int2[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int2[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV119Wpbandejacitasds_12_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int2[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int2[28] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int2[29] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int2[30] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int2[31] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int2[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int2[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int2[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int2[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int2[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int2[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int2[38] = (byte)(1) ;
      }
      if ( AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV131Wpbandejacitasds_24_tfcitaestadocita_sels, "T1.[CitaEstadoCita] IN (", ")")+")");
      }
      if ( AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV132Wpbandejacitasds_25_tfcitaestadopago_sels, "T1.[CitaEstadoPago] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int2[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int2[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) && ( ! (GXutil.strcmp("", AV135Wpbandejacitasds_28_tfcitaarchivoextencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] like ?)");
      }
      else
      {
         GXv_int2[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] = ?)");
      }
      else
      {
         GXv_int2[42] = (byte)(1) ;
      }
      if ( AV99SecRoleId != 1 )
      {
         addWhere(sWhereString, "(T3.[ProfesionalId] = ?)");
      }
      else
      {
         GXv_int2[43] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[CitaCode]" ;
      GXv_Object3[0] = scmdbuf ;
      GXv_Object3[1] = GXv_int2 ;
      return GXv_Object3 ;
   }

   protected Object[] conditional_P003U3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A89CitaEstadoCita ,
                                          GXSimpleCollection<String> AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                          String A102CitaEstadoPago ,
                                          GXSimpleCollection<String> AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                          String AV108Wpbandejacitasds_1_filterfulltext ,
                                          int AV109Wpbandejacitasds_2_tfcitaid ,
                                          int AV110Wpbandejacitasds_3_tfcitaid_to ,
                                          String AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                          String AV111Wpbandejacitasds_4_tfcitacode ,
                                          String AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                          String AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                          String AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                          String AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                          String AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                          String AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                          String AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                          String AV119Wpbandejacitasds_12_tfpacientenombres ,
                                          java.util.Date AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                          java.util.Date AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                          java.util.Date AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                          String AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                          String AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                          String AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                          String AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                          int AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size ,
                                          int AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size ,
                                          java.util.Date AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                          java.util.Date AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                          String AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                          String AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                          short AV99SecRoleId ,
                                          String A64CitaCode ,
                                          String A106PacienteNroDocumento ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          String A73SGCitaDisponibilidadSedeNombre ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          int A19CitaId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A68SGCitaDisponibilidadHoraInicio ,
                                          java.util.Date A387SGCitaDisponibilidadHoraFin ,
                                          String A333CitaArchivoExtencion ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          int AV98ProfesionalId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[44];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteId], T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T3.[SGSedeDisponibilidadSedeId]" ;
      scmdbuf += " AS SGCitaDisponibilidadSedeId, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T2.[PacienteNroDocumento], T3.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId," ;
      scmdbuf += " T1.[CitaArchivoExtencion], T3.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T3.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, T3.[DisponibilidadFecha]" ;
      scmdbuf += " AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[CitaEstadoPago], T1.[CitaEstadoCita], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T5.[SedeNombre]" ;
      scmdbuf += " AS SGCitaDisponibilidadSedeNombre, T4.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T2.[PacienteNombres], T2.[PacienteApellidoMaterno], T2.[PacienteApellidoPaterno]," ;
      scmdbuf += " T1.[CitaCode] FROM ((((([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId])" ;
      scmdbuf += " INNER JOIN [Especialidad] T4 ON T4.[EspecialidadId] = T3.[EspecialidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica]" ;
      scmdbuf += " T6 ON T6.[ClinicaId] = T5.[ClinicaId])" ;
      if ( ! (GXutil.strcmp("", AV108Wpbandejacitasds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[CitaCode] like '%' + ?) or ( T2.[PacienteNroDocumento] like '%' + ?) or ( T2.[PacienteApellidoPaterno] like '%' + ?) or ( T2.[PacienteApellidoMaterno] like '%' + ?) or ( T2.[PacienteNombres] like '%' + ?) or ( T4.[EspecialidadNombre] like '%' + ?) or ( T5.[SedeNombre] like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( 'sin pago' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'S') or ( 'pendiente' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'P') or ( 'pagado' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'G'))");
      }
      else
      {
         GXv_int5[0] = (byte)(1) ;
         GXv_int5[1] = (byte)(1) ;
         GXv_int5[2] = (byte)(1) ;
         GXv_int5[3] = (byte)(1) ;
         GXv_int5[4] = (byte)(1) ;
         GXv_int5[5] = (byte)(1) ;
         GXv_int5[6] = (byte)(1) ;
         GXv_int5[7] = (byte)(1) ;
         GXv_int5[8] = (byte)(1) ;
         GXv_int5[9] = (byte)(1) ;
         GXv_int5[10] = (byte)(1) ;
         GXv_int5[11] = (byte)(1) ;
         GXv_int5[12] = (byte)(1) ;
         GXv_int5[13] = (byte)(1) ;
         GXv_int5[14] = (byte)(1) ;
         GXv_int5[15] = (byte)(1) ;
         GXv_int5[16] = (byte)(1) ;
      }
      if ( ! (0==AV109Wpbandejacitasds_2_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int5[17] = (byte)(1) ;
      }
      if ( ! (0==AV110Wpbandejacitasds_3_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int5[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV111Wpbandejacitasds_4_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] like ?)");
      }
      else
      {
         GXv_int5[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] = ?)");
      }
      else
      {
         GXv_int5[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV113Wpbandejacitasds_6_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int5[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int5[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV115Wpbandejacitasds_8_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int5[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int5[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV117Wpbandejacitasds_10_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int5[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int5[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV119Wpbandejacitasds_12_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int5[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int5[28] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int5[29] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int5[30] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int5[31] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int5[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int5[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int5[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int5[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int5[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int5[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int5[38] = (byte)(1) ;
      }
      if ( AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV131Wpbandejacitasds_24_tfcitaestadocita_sels, "T1.[CitaEstadoCita] IN (", ")")+")");
      }
      if ( AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV132Wpbandejacitasds_25_tfcitaestadopago_sels, "T1.[CitaEstadoPago] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int5[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int5[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) && ( ! (GXutil.strcmp("", AV135Wpbandejacitasds_28_tfcitaarchivoextencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] like ?)");
      }
      else
      {
         GXv_int5[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] = ?)");
      }
      else
      {
         GXv_int5[42] = (byte)(1) ;
      }
      if ( AV99SecRoleId != 1 )
      {
         addWhere(sWhereString, "(T3.[ProfesionalId] = ?)");
      }
      else
      {
         GXv_int5[43] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.[PacienteNroDocumento]" ;
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
   }

   protected Object[] conditional_P003U4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A89CitaEstadoCita ,
                                          GXSimpleCollection<String> AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                          String A102CitaEstadoPago ,
                                          GXSimpleCollection<String> AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                          String AV108Wpbandejacitasds_1_filterfulltext ,
                                          int AV109Wpbandejacitasds_2_tfcitaid ,
                                          int AV110Wpbandejacitasds_3_tfcitaid_to ,
                                          String AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                          String AV111Wpbandejacitasds_4_tfcitacode ,
                                          String AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                          String AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                          String AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                          String AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                          String AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                          String AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                          String AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                          String AV119Wpbandejacitasds_12_tfpacientenombres ,
                                          java.util.Date AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                          java.util.Date AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                          java.util.Date AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                          String AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                          String AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                          String AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                          String AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                          int AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size ,
                                          int AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size ,
                                          java.util.Date AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                          java.util.Date AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                          String AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                          String AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                          short AV99SecRoleId ,
                                          String A64CitaCode ,
                                          String A106PacienteNroDocumento ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          String A73SGCitaDisponibilidadSedeNombre ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          int A19CitaId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A68SGCitaDisponibilidadHoraInicio ,
                                          java.util.Date A387SGCitaDisponibilidadHoraFin ,
                                          String A333CitaArchivoExtencion ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          int AV98ProfesionalId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[44];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteId], T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T3.[SGSedeDisponibilidadSedeId]" ;
      scmdbuf += " AS SGCitaDisponibilidadSedeId, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T2.[PacienteApellidoPaterno], T3.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId," ;
      scmdbuf += " T1.[CitaArchivoExtencion], T3.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T3.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, T3.[DisponibilidadFecha]" ;
      scmdbuf += " AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[CitaEstadoPago], T1.[CitaEstadoCita], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T5.[SedeNombre]" ;
      scmdbuf += " AS SGCitaDisponibilidadSedeNombre, T4.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T2.[PacienteNombres], T2.[PacienteApellidoMaterno], T2.[PacienteNroDocumento]," ;
      scmdbuf += " T1.[CitaCode] FROM ((((([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId])" ;
      scmdbuf += " INNER JOIN [Especialidad] T4 ON T4.[EspecialidadId] = T3.[EspecialidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica]" ;
      scmdbuf += " T6 ON T6.[ClinicaId] = T5.[ClinicaId])" ;
      if ( ! (GXutil.strcmp("", AV108Wpbandejacitasds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[CitaCode] like '%' + ?) or ( T2.[PacienteNroDocumento] like '%' + ?) or ( T2.[PacienteApellidoPaterno] like '%' + ?) or ( T2.[PacienteApellidoMaterno] like '%' + ?) or ( T2.[PacienteNombres] like '%' + ?) or ( T4.[EspecialidadNombre] like '%' + ?) or ( T5.[SedeNombre] like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( 'sin pago' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'S') or ( 'pendiente' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'P') or ( 'pagado' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'G'))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
         GXv_int8[1] = (byte)(1) ;
         GXv_int8[2] = (byte)(1) ;
         GXv_int8[3] = (byte)(1) ;
         GXv_int8[4] = (byte)(1) ;
         GXv_int8[5] = (byte)(1) ;
         GXv_int8[6] = (byte)(1) ;
         GXv_int8[7] = (byte)(1) ;
         GXv_int8[8] = (byte)(1) ;
         GXv_int8[9] = (byte)(1) ;
         GXv_int8[10] = (byte)(1) ;
         GXv_int8[11] = (byte)(1) ;
         GXv_int8[12] = (byte)(1) ;
         GXv_int8[13] = (byte)(1) ;
         GXv_int8[14] = (byte)(1) ;
         GXv_int8[15] = (byte)(1) ;
         GXv_int8[16] = (byte)(1) ;
      }
      if ( ! (0==AV109Wpbandejacitasds_2_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int8[17] = (byte)(1) ;
      }
      if ( ! (0==AV110Wpbandejacitasds_3_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int8[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV111Wpbandejacitasds_4_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] like ?)");
      }
      else
      {
         GXv_int8[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] = ?)");
      }
      else
      {
         GXv_int8[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV113Wpbandejacitasds_6_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int8[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int8[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV115Wpbandejacitasds_8_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int8[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int8[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV117Wpbandejacitasds_10_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int8[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int8[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV119Wpbandejacitasds_12_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int8[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int8[28] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int8[29] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int8[30] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int8[31] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int8[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int8[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int8[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int8[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int8[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int8[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int8[38] = (byte)(1) ;
      }
      if ( AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV131Wpbandejacitasds_24_tfcitaestadocita_sels, "T1.[CitaEstadoCita] IN (", ")")+")");
      }
      if ( AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV132Wpbandejacitasds_25_tfcitaestadopago_sels, "T1.[CitaEstadoPago] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int8[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int8[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) && ( ! (GXutil.strcmp("", AV135Wpbandejacitasds_28_tfcitaarchivoextencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] like ?)");
      }
      else
      {
         GXv_int8[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] = ?)");
      }
      else
      {
         GXv_int8[42] = (byte)(1) ;
      }
      if ( AV99SecRoleId != 1 )
      {
         addWhere(sWhereString, "(T3.[ProfesionalId] = ?)");
      }
      else
      {
         GXv_int8[43] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.[PacienteApellidoPaterno]" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P003U5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A89CitaEstadoCita ,
                                          GXSimpleCollection<String> AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                          String A102CitaEstadoPago ,
                                          GXSimpleCollection<String> AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                          String AV108Wpbandejacitasds_1_filterfulltext ,
                                          int AV109Wpbandejacitasds_2_tfcitaid ,
                                          int AV110Wpbandejacitasds_3_tfcitaid_to ,
                                          String AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                          String AV111Wpbandejacitasds_4_tfcitacode ,
                                          String AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                          String AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                          String AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                          String AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                          String AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                          String AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                          String AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                          String AV119Wpbandejacitasds_12_tfpacientenombres ,
                                          java.util.Date AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                          java.util.Date AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                          java.util.Date AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                          String AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                          String AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                          String AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                          String AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                          int AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size ,
                                          int AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size ,
                                          java.util.Date AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                          java.util.Date AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                          String AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                          String AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                          short AV99SecRoleId ,
                                          String A64CitaCode ,
                                          String A106PacienteNroDocumento ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          String A73SGCitaDisponibilidadSedeNombre ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          int A19CitaId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A68SGCitaDisponibilidadHoraInicio ,
                                          java.util.Date A387SGCitaDisponibilidadHoraFin ,
                                          String A333CitaArchivoExtencion ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          int AV98ProfesionalId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[44];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteId], T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T3.[SGSedeDisponibilidadSedeId]" ;
      scmdbuf += " AS SGCitaDisponibilidadSedeId, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T2.[PacienteApellidoMaterno], T3.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId," ;
      scmdbuf += " T1.[CitaArchivoExtencion], T3.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T3.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, T3.[DisponibilidadFecha]" ;
      scmdbuf += " AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[CitaEstadoPago], T1.[CitaEstadoCita], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T5.[SedeNombre]" ;
      scmdbuf += " AS SGCitaDisponibilidadSedeNombre, T4.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T2.[PacienteNombres], T2.[PacienteApellidoPaterno], T2.[PacienteNroDocumento]," ;
      scmdbuf += " T1.[CitaCode] FROM ((((([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId])" ;
      scmdbuf += " INNER JOIN [Especialidad] T4 ON T4.[EspecialidadId] = T3.[EspecialidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica]" ;
      scmdbuf += " T6 ON T6.[ClinicaId] = T5.[ClinicaId])" ;
      if ( ! (GXutil.strcmp("", AV108Wpbandejacitasds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[CitaCode] like '%' + ?) or ( T2.[PacienteNroDocumento] like '%' + ?) or ( T2.[PacienteApellidoPaterno] like '%' + ?) or ( T2.[PacienteApellidoMaterno] like '%' + ?) or ( T2.[PacienteNombres] like '%' + ?) or ( T4.[EspecialidadNombre] like '%' + ?) or ( T5.[SedeNombre] like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( 'sin pago' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'S') or ( 'pendiente' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'P') or ( 'pagado' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'G'))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
         GXv_int11[1] = (byte)(1) ;
         GXv_int11[2] = (byte)(1) ;
         GXv_int11[3] = (byte)(1) ;
         GXv_int11[4] = (byte)(1) ;
         GXv_int11[5] = (byte)(1) ;
         GXv_int11[6] = (byte)(1) ;
         GXv_int11[7] = (byte)(1) ;
         GXv_int11[8] = (byte)(1) ;
         GXv_int11[9] = (byte)(1) ;
         GXv_int11[10] = (byte)(1) ;
         GXv_int11[11] = (byte)(1) ;
         GXv_int11[12] = (byte)(1) ;
         GXv_int11[13] = (byte)(1) ;
         GXv_int11[14] = (byte)(1) ;
         GXv_int11[15] = (byte)(1) ;
         GXv_int11[16] = (byte)(1) ;
      }
      if ( ! (0==AV109Wpbandejacitasds_2_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int11[17] = (byte)(1) ;
      }
      if ( ! (0==AV110Wpbandejacitasds_3_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int11[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV111Wpbandejacitasds_4_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] like ?)");
      }
      else
      {
         GXv_int11[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] = ?)");
      }
      else
      {
         GXv_int11[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV113Wpbandejacitasds_6_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int11[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int11[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV115Wpbandejacitasds_8_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int11[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int11[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV117Wpbandejacitasds_10_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int11[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int11[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV119Wpbandejacitasds_12_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int11[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int11[28] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int11[29] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int11[30] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int11[31] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int11[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int11[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int11[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int11[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int11[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int11[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int11[38] = (byte)(1) ;
      }
      if ( AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV131Wpbandejacitasds_24_tfcitaestadocita_sels, "T1.[CitaEstadoCita] IN (", ")")+")");
      }
      if ( AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV132Wpbandejacitasds_25_tfcitaestadopago_sels, "T1.[CitaEstadoPago] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int11[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int11[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) && ( ! (GXutil.strcmp("", AV135Wpbandejacitasds_28_tfcitaarchivoextencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] like ?)");
      }
      else
      {
         GXv_int11[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] = ?)");
      }
      else
      {
         GXv_int11[42] = (byte)(1) ;
      }
      if ( AV99SecRoleId != 1 )
      {
         addWhere(sWhereString, "(T3.[ProfesionalId] = ?)");
      }
      else
      {
         GXv_int11[43] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.[PacienteApellidoMaterno]" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P003U6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A89CitaEstadoCita ,
                                          GXSimpleCollection<String> AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                          String A102CitaEstadoPago ,
                                          GXSimpleCollection<String> AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                          String AV108Wpbandejacitasds_1_filterfulltext ,
                                          int AV109Wpbandejacitasds_2_tfcitaid ,
                                          int AV110Wpbandejacitasds_3_tfcitaid_to ,
                                          String AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                          String AV111Wpbandejacitasds_4_tfcitacode ,
                                          String AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                          String AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                          String AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                          String AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                          String AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                          String AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                          String AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                          String AV119Wpbandejacitasds_12_tfpacientenombres ,
                                          java.util.Date AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                          java.util.Date AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                          java.util.Date AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                          String AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                          String AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                          String AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                          String AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                          int AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size ,
                                          int AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size ,
                                          java.util.Date AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                          java.util.Date AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                          String AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                          String AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                          short AV99SecRoleId ,
                                          String A64CitaCode ,
                                          String A106PacienteNroDocumento ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          String A73SGCitaDisponibilidadSedeNombre ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          int A19CitaId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A68SGCitaDisponibilidadHoraInicio ,
                                          java.util.Date A387SGCitaDisponibilidadHoraFin ,
                                          String A333CitaArchivoExtencion ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          int AV98ProfesionalId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[44];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T2.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T2.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId," ;
      scmdbuf += " T4.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T1.[PacienteId], T2.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T1.[CitaArchivoExtencion], T2.[DisponibilidadHoraFin]" ;
      scmdbuf += " AS SGCitaDisponibilidadHoraFin, T2.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, T2.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId]," ;
      scmdbuf += " T1.[CitaEstadoPago], T1.[CitaEstadoCita], T5.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T4.[SedeNombre] AS SGCitaDisponibilidadSedeNombre, T3.[EspecialidadNombre]" ;
      scmdbuf += " AS SGCitaDisponibilidadEspecialidadNombre, T6.[PacienteNombres], T6.[PacienteApellidoMaterno], T6.[PacienteApellidoPaterno], T6.[PacienteNroDocumento], T1.[CitaCode]" ;
      scmdbuf += " FROM ((((([Cita] T1 INNER JOIN [Disponibilidad] T2 ON T2.[DisponibilidadId] = T1.[SGCitaDisponibilidadId]) INNER JOIN [Especialidad] T3 ON T3.[EspecialidadId] =" ;
      scmdbuf += " T2.[EspecialidadId]) INNER JOIN [Sede] T4 ON T4.[SedeId] = T2.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T5 ON T5.[ClinicaId] = T4.[ClinicaId]) INNER JOIN" ;
      scmdbuf += " [Paciente] T6 ON T6.[PacienteId] = T1.[PacienteId])" ;
      if ( ! (GXutil.strcmp("", AV108Wpbandejacitasds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[CitaCode] like '%' + ?) or ( T6.[PacienteNroDocumento] like '%' + ?) or ( T6.[PacienteApellidoPaterno] like '%' + ?) or ( T6.[PacienteApellidoMaterno] like '%' + ?) or ( T6.[PacienteNombres] like '%' + ?) or ( T3.[EspecialidadNombre] like '%' + ?) or ( T4.[SedeNombre] like '%' + ?) or ( T5.[ClinicaNombreAbreviado] like '%' + ?) or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( 'sin pago' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'S') or ( 'pendiente' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'P') or ( 'pagado' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'G'))");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
         GXv_int14[1] = (byte)(1) ;
         GXv_int14[2] = (byte)(1) ;
         GXv_int14[3] = (byte)(1) ;
         GXv_int14[4] = (byte)(1) ;
         GXv_int14[5] = (byte)(1) ;
         GXv_int14[6] = (byte)(1) ;
         GXv_int14[7] = (byte)(1) ;
         GXv_int14[8] = (byte)(1) ;
         GXv_int14[9] = (byte)(1) ;
         GXv_int14[10] = (byte)(1) ;
         GXv_int14[11] = (byte)(1) ;
         GXv_int14[12] = (byte)(1) ;
         GXv_int14[13] = (byte)(1) ;
         GXv_int14[14] = (byte)(1) ;
         GXv_int14[15] = (byte)(1) ;
         GXv_int14[16] = (byte)(1) ;
      }
      if ( ! (0==AV109Wpbandejacitasds_2_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int14[17] = (byte)(1) ;
      }
      if ( ! (0==AV110Wpbandejacitasds_3_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int14[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV111Wpbandejacitasds_4_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] like ?)");
      }
      else
      {
         GXv_int14[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] = ?)");
      }
      else
      {
         GXv_int14[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV113Wpbandejacitasds_6_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T6.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int14[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int14[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV115Wpbandejacitasds_8_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T6.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int14[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int14[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV117Wpbandejacitasds_10_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T6.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int14[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int14[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV119Wpbandejacitasds_12_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T6.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int14[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int14[28] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int14[29] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int14[30] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int14[31] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int14[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int14[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int14[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T4.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int14[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int14[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T5.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int14[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int14[38] = (byte)(1) ;
      }
      if ( AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV131Wpbandejacitasds_24_tfcitaestadocita_sels, "T1.[CitaEstadoCita] IN (", ")")+")");
      }
      if ( AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV132Wpbandejacitasds_25_tfcitaestadopago_sels, "T1.[CitaEstadoPago] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int14[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T2.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int14[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) && ( ! (GXutil.strcmp("", AV135Wpbandejacitasds_28_tfcitaarchivoextencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] like ?)");
      }
      else
      {
         GXv_int14[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] = ?)");
      }
      else
      {
         GXv_int14[42] = (byte)(1) ;
      }
      if ( AV99SecRoleId != 1 )
      {
         addWhere(sWhereString, "(T2.[ProfesionalId] = ?)");
      }
      else
      {
         GXv_int14[43] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[PacienteId]" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P003U7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A89CitaEstadoCita ,
                                          GXSimpleCollection<String> AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                          String A102CitaEstadoPago ,
                                          GXSimpleCollection<String> AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                          String AV108Wpbandejacitasds_1_filterfulltext ,
                                          int AV109Wpbandejacitasds_2_tfcitaid ,
                                          int AV110Wpbandejacitasds_3_tfcitaid_to ,
                                          String AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                          String AV111Wpbandejacitasds_4_tfcitacode ,
                                          String AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                          String AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                          String AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                          String AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                          String AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                          String AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                          String AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                          String AV119Wpbandejacitasds_12_tfpacientenombres ,
                                          java.util.Date AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                          java.util.Date AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                          java.util.Date AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                          String AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                          String AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                          String AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                          String AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                          int AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size ,
                                          int AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size ,
                                          java.util.Date AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                          java.util.Date AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                          String AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                          String AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                          short AV99SecRoleId ,
                                          String A64CitaCode ,
                                          String A106PacienteNroDocumento ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          String A73SGCitaDisponibilidadSedeNombre ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          int A19CitaId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A68SGCitaDisponibilidadHoraInicio ,
                                          java.util.Date A387SGCitaDisponibilidadHoraFin ,
                                          String A333CitaArchivoExtencion ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          int AV98ProfesionalId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[44];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteId], T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T3.[SGSedeDisponibilidadSedeId]" ;
      scmdbuf += " AS SGCitaDisponibilidadSedeId, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T4.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T3.[ProfesionalId]" ;
      scmdbuf += " AS SGCitaDisponibilidadProfesionalId, T1.[CitaArchivoExtencion], T3.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T3.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio," ;
      scmdbuf += " T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[CitaEstadoPago], T1.[CitaEstadoCita], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre," ;
      scmdbuf += " T5.[SedeNombre] AS SGCitaDisponibilidadSedeNombre, T2.[PacienteNombres], T2.[PacienteApellidoMaterno], T2.[PacienteApellidoPaterno], T2.[PacienteNroDocumento]," ;
      scmdbuf += " T1.[CitaCode] FROM ((((([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId])" ;
      scmdbuf += " INNER JOIN [Especialidad] T4 ON T4.[EspecialidadId] = T3.[EspecialidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica]" ;
      scmdbuf += " T6 ON T6.[ClinicaId] = T5.[ClinicaId])" ;
      if ( ! (GXutil.strcmp("", AV108Wpbandejacitasds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[CitaCode] like '%' + ?) or ( T2.[PacienteNroDocumento] like '%' + ?) or ( T2.[PacienteApellidoPaterno] like '%' + ?) or ( T2.[PacienteApellidoMaterno] like '%' + ?) or ( T2.[PacienteNombres] like '%' + ?) or ( T4.[EspecialidadNombre] like '%' + ?) or ( T5.[SedeNombre] like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( 'sin pago' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'S') or ( 'pendiente' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'P') or ( 'pagado' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'G'))");
      }
      else
      {
         GXv_int17[0] = (byte)(1) ;
         GXv_int17[1] = (byte)(1) ;
         GXv_int17[2] = (byte)(1) ;
         GXv_int17[3] = (byte)(1) ;
         GXv_int17[4] = (byte)(1) ;
         GXv_int17[5] = (byte)(1) ;
         GXv_int17[6] = (byte)(1) ;
         GXv_int17[7] = (byte)(1) ;
         GXv_int17[8] = (byte)(1) ;
         GXv_int17[9] = (byte)(1) ;
         GXv_int17[10] = (byte)(1) ;
         GXv_int17[11] = (byte)(1) ;
         GXv_int17[12] = (byte)(1) ;
         GXv_int17[13] = (byte)(1) ;
         GXv_int17[14] = (byte)(1) ;
         GXv_int17[15] = (byte)(1) ;
         GXv_int17[16] = (byte)(1) ;
      }
      if ( ! (0==AV109Wpbandejacitasds_2_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int17[17] = (byte)(1) ;
      }
      if ( ! (0==AV110Wpbandejacitasds_3_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int17[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV111Wpbandejacitasds_4_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] like ?)");
      }
      else
      {
         GXv_int17[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] = ?)");
      }
      else
      {
         GXv_int17[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV113Wpbandejacitasds_6_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int17[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int17[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV115Wpbandejacitasds_8_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int17[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int17[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV117Wpbandejacitasds_10_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int17[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int17[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV119Wpbandejacitasds_12_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int17[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int17[28] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int17[29] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int17[30] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int17[31] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int17[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int17[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int17[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int17[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int17[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int17[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int17[38] = (byte)(1) ;
      }
      if ( AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV131Wpbandejacitasds_24_tfcitaestadocita_sels, "T1.[CitaEstadoCita] IN (", ")")+")");
      }
      if ( AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV132Wpbandejacitasds_25_tfcitaestadopago_sels, "T1.[CitaEstadoPago] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int17[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int17[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) && ( ! (GXutil.strcmp("", AV135Wpbandejacitasds_28_tfcitaarchivoextencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] like ?)");
      }
      else
      {
         GXv_int17[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] = ?)");
      }
      else
      {
         GXv_int17[42] = (byte)(1) ;
      }
      if ( AV99SecRoleId != 1 )
      {
         addWhere(sWhereString, "(T3.[ProfesionalId] = ?)");
      }
      else
      {
         GXv_int17[43] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T4.[EspecialidadNombre]" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   protected Object[] conditional_P003U8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A89CitaEstadoCita ,
                                          GXSimpleCollection<String> AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                          String A102CitaEstadoPago ,
                                          GXSimpleCollection<String> AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                          String AV108Wpbandejacitasds_1_filterfulltext ,
                                          int AV109Wpbandejacitasds_2_tfcitaid ,
                                          int AV110Wpbandejacitasds_3_tfcitaid_to ,
                                          String AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                          String AV111Wpbandejacitasds_4_tfcitacode ,
                                          String AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                          String AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                          String AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                          String AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                          String AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                          String AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                          String AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                          String AV119Wpbandejacitasds_12_tfpacientenombres ,
                                          java.util.Date AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                          java.util.Date AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                          java.util.Date AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                          String AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                          String AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                          String AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                          String AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                          int AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size ,
                                          int AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size ,
                                          java.util.Date AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                          java.util.Date AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                          String AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                          String AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                          short AV99SecRoleId ,
                                          String A64CitaCode ,
                                          String A106PacienteNroDocumento ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          String A73SGCitaDisponibilidadSedeNombre ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          int A19CitaId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A68SGCitaDisponibilidadHoraInicio ,
                                          java.util.Date A387SGCitaDisponibilidadHoraFin ,
                                          String A333CitaArchivoExtencion ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          int AV98ProfesionalId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[44];
      Object[] GXv_Object21 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteId], T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T3.[SGSedeDisponibilidadSedeId]" ;
      scmdbuf += " AS SGCitaDisponibilidadSedeId, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T5.[SedeNombre] AS SGCitaDisponibilidadSedeNombre, T3.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId," ;
      scmdbuf += " T1.[CitaArchivoExtencion], T3.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T3.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, T3.[DisponibilidadFecha]" ;
      scmdbuf += " AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[CitaEstadoPago], T1.[CitaEstadoCita], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T4.[EspecialidadNombre]" ;
      scmdbuf += " AS SGCitaDisponibilidadEspecialidadNombre, T2.[PacienteNombres], T2.[PacienteApellidoMaterno], T2.[PacienteApellidoPaterno], T2.[PacienteNroDocumento], T1.[CitaCode]" ;
      scmdbuf += " FROM ((((([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId])" ;
      scmdbuf += " INNER JOIN [Especialidad] T4 ON T4.[EspecialidadId] = T3.[EspecialidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica]" ;
      scmdbuf += " T6 ON T6.[ClinicaId] = T5.[ClinicaId])" ;
      if ( ! (GXutil.strcmp("", AV108Wpbandejacitasds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[CitaCode] like '%' + ?) or ( T2.[PacienteNroDocumento] like '%' + ?) or ( T2.[PacienteApellidoPaterno] like '%' + ?) or ( T2.[PacienteApellidoMaterno] like '%' + ?) or ( T2.[PacienteNombres] like '%' + ?) or ( T4.[EspecialidadNombre] like '%' + ?) or ( T5.[SedeNombre] like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( 'sin pago' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'S') or ( 'pendiente' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'P') or ( 'pagado' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'G'))");
      }
      else
      {
         GXv_int20[0] = (byte)(1) ;
         GXv_int20[1] = (byte)(1) ;
         GXv_int20[2] = (byte)(1) ;
         GXv_int20[3] = (byte)(1) ;
         GXv_int20[4] = (byte)(1) ;
         GXv_int20[5] = (byte)(1) ;
         GXv_int20[6] = (byte)(1) ;
         GXv_int20[7] = (byte)(1) ;
         GXv_int20[8] = (byte)(1) ;
         GXv_int20[9] = (byte)(1) ;
         GXv_int20[10] = (byte)(1) ;
         GXv_int20[11] = (byte)(1) ;
         GXv_int20[12] = (byte)(1) ;
         GXv_int20[13] = (byte)(1) ;
         GXv_int20[14] = (byte)(1) ;
         GXv_int20[15] = (byte)(1) ;
         GXv_int20[16] = (byte)(1) ;
      }
      if ( ! (0==AV109Wpbandejacitasds_2_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int20[17] = (byte)(1) ;
      }
      if ( ! (0==AV110Wpbandejacitasds_3_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int20[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV111Wpbandejacitasds_4_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] like ?)");
      }
      else
      {
         GXv_int20[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] = ?)");
      }
      else
      {
         GXv_int20[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV113Wpbandejacitasds_6_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int20[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int20[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV115Wpbandejacitasds_8_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int20[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int20[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV117Wpbandejacitasds_10_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int20[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int20[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV119Wpbandejacitasds_12_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int20[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int20[28] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int20[29] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int20[30] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int20[31] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int20[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int20[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int20[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int20[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int20[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int20[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int20[38] = (byte)(1) ;
      }
      if ( AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV131Wpbandejacitasds_24_tfcitaestadocita_sels, "T1.[CitaEstadoCita] IN (", ")")+")");
      }
      if ( AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV132Wpbandejacitasds_25_tfcitaestadopago_sels, "T1.[CitaEstadoPago] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int20[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int20[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) && ( ! (GXutil.strcmp("", AV135Wpbandejacitasds_28_tfcitaarchivoextencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] like ?)");
      }
      else
      {
         GXv_int20[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] = ?)");
      }
      else
      {
         GXv_int20[42] = (byte)(1) ;
      }
      if ( AV99SecRoleId != 1 )
      {
         addWhere(sWhereString, "(T3.[ProfesionalId] = ?)");
      }
      else
      {
         GXv_int20[43] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T5.[SedeNombre]" ;
      GXv_Object21[0] = scmdbuf ;
      GXv_Object21[1] = GXv_int20 ;
      return GXv_Object21 ;
   }

   protected Object[] conditional_P003U9( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A89CitaEstadoCita ,
                                          GXSimpleCollection<String> AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                          String A102CitaEstadoPago ,
                                          GXSimpleCollection<String> AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                          String AV108Wpbandejacitasds_1_filterfulltext ,
                                          int AV109Wpbandejacitasds_2_tfcitaid ,
                                          int AV110Wpbandejacitasds_3_tfcitaid_to ,
                                          String AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                          String AV111Wpbandejacitasds_4_tfcitacode ,
                                          String AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                          String AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                          String AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                          String AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                          String AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                          String AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                          String AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                          String AV119Wpbandejacitasds_12_tfpacientenombres ,
                                          java.util.Date AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                          java.util.Date AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                          java.util.Date AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                          String AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                          String AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                          String AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                          String AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                          int AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size ,
                                          int AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size ,
                                          java.util.Date AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                          java.util.Date AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                          String AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                          String AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                          short AV99SecRoleId ,
                                          String A64CitaCode ,
                                          String A106PacienteNroDocumento ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          String A73SGCitaDisponibilidadSedeNombre ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          int A19CitaId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A68SGCitaDisponibilidadHoraInicio ,
                                          java.util.Date A387SGCitaDisponibilidadHoraFin ,
                                          String A333CitaArchivoExtencion ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          int AV98ProfesionalId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int23 = new byte[44];
      Object[] GXv_Object24 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteId], T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T3.[SGSedeDisponibilidadSedeId]" ;
      scmdbuf += " AS SGCitaDisponibilidadSedeId, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T3.[ProfesionalId]" ;
      scmdbuf += " AS SGCitaDisponibilidadProfesionalId, T1.[CitaArchivoExtencion], T3.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T3.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio," ;
      scmdbuf += " T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[CitaId], T1.[CitaEstadoPago], T1.[CitaEstadoCita], T5.[SedeNombre] AS SGCitaDisponibilidadSedeNombre," ;
      scmdbuf += " T4.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T2.[PacienteNombres], T2.[PacienteApellidoMaterno], T2.[PacienteApellidoPaterno], T2.[PacienteNroDocumento]," ;
      scmdbuf += " T1.[CitaCode] FROM ((((([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId])" ;
      scmdbuf += " INNER JOIN [Especialidad] T4 ON T4.[EspecialidadId] = T3.[EspecialidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica]" ;
      scmdbuf += " T6 ON T6.[ClinicaId] = T5.[ClinicaId])" ;
      if ( ! (GXutil.strcmp("", AV108Wpbandejacitasds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[CitaCode] like '%' + ?) or ( T2.[PacienteNroDocumento] like '%' + ?) or ( T2.[PacienteApellidoPaterno] like '%' + ?) or ( T2.[PacienteApellidoMaterno] like '%' + ?) or ( T2.[PacienteNombres] like '%' + ?) or ( T4.[EspecialidadNombre] like '%' + ?) or ( T5.[SedeNombre] like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( 'sin pago' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'S') or ( 'pendiente' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'P') or ( 'pagado' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'G'))");
      }
      else
      {
         GXv_int23[0] = (byte)(1) ;
         GXv_int23[1] = (byte)(1) ;
         GXv_int23[2] = (byte)(1) ;
         GXv_int23[3] = (byte)(1) ;
         GXv_int23[4] = (byte)(1) ;
         GXv_int23[5] = (byte)(1) ;
         GXv_int23[6] = (byte)(1) ;
         GXv_int23[7] = (byte)(1) ;
         GXv_int23[8] = (byte)(1) ;
         GXv_int23[9] = (byte)(1) ;
         GXv_int23[10] = (byte)(1) ;
         GXv_int23[11] = (byte)(1) ;
         GXv_int23[12] = (byte)(1) ;
         GXv_int23[13] = (byte)(1) ;
         GXv_int23[14] = (byte)(1) ;
         GXv_int23[15] = (byte)(1) ;
         GXv_int23[16] = (byte)(1) ;
      }
      if ( ! (0==AV109Wpbandejacitasds_2_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int23[17] = (byte)(1) ;
      }
      if ( ! (0==AV110Wpbandejacitasds_3_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int23[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV111Wpbandejacitasds_4_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] like ?)");
      }
      else
      {
         GXv_int23[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] = ?)");
      }
      else
      {
         GXv_int23[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV113Wpbandejacitasds_6_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int23[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int23[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV115Wpbandejacitasds_8_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int23[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int23[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV117Wpbandejacitasds_10_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int23[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int23[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV119Wpbandejacitasds_12_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int23[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int23[28] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int23[29] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int23[30] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int23[31] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int23[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int23[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int23[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int23[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int23[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int23[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int23[38] = (byte)(1) ;
      }
      if ( AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV131Wpbandejacitasds_24_tfcitaestadocita_sels, "T1.[CitaEstadoCita] IN (", ")")+")");
      }
      if ( AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV132Wpbandejacitasds_25_tfcitaestadopago_sels, "T1.[CitaEstadoPago] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int23[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int23[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) && ( ! (GXutil.strcmp("", AV135Wpbandejacitasds_28_tfcitaarchivoextencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] like ?)");
      }
      else
      {
         GXv_int23[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] = ?)");
      }
      else
      {
         GXv_int23[42] = (byte)(1) ;
      }
      if ( AV99SecRoleId != 1 )
      {
         addWhere(sWhereString, "(T3.[ProfesionalId] = ?)");
      }
      else
      {
         GXv_int23[43] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T6.[ClinicaNombreAbreviado]" ;
      GXv_Object24[0] = scmdbuf ;
      GXv_Object24[1] = GXv_int23 ;
      return GXv_Object24 ;
   }

   protected Object[] conditional_P003U10( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A89CitaEstadoCita ,
                                           GXSimpleCollection<String> AV131Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                           String A102CitaEstadoPago ,
                                           GXSimpleCollection<String> AV132Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                           String AV108Wpbandejacitasds_1_filterfulltext ,
                                           int AV109Wpbandejacitasds_2_tfcitaid ,
                                           int AV110Wpbandejacitasds_3_tfcitaid_to ,
                                           String AV112Wpbandejacitasds_5_tfcitacode_sel ,
                                           String AV111Wpbandejacitasds_4_tfcitacode ,
                                           String AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                           String AV113Wpbandejacitasds_6_tfpacientenrodocumento ,
                                           String AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                           String AV115Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                           String AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                           String AV117Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                           String AV120Wpbandejacitasds_13_tfpacientenombres_sel ,
                                           String AV119Wpbandejacitasds_12_tfpacientenombres ,
                                           java.util.Date AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                           java.util.Date AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                           java.util.Date AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                           java.util.Date AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                           String AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           String AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                           String AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                           String AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                           String AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                           String AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                           int AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size ,
                                           int AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size ,
                                           java.util.Date AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                           java.util.Date AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                           String AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                           String AV135Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                           short AV99SecRoleId ,
                                           String A64CitaCode ,
                                           String A106PacienteNroDocumento ,
                                           String A103PacienteApellidoPaterno ,
                                           String A104PacienteApellidoMaterno ,
                                           String A105PacienteNombres ,
                                           String A146SGCitaDisponibilidadEspecialidadNombre ,
                                           String A73SGCitaDisponibilidadSedeNombre ,
                                           String A78SGCitaDisponibilidadClinicaNombre ,
                                           int A19CitaId ,
                                           java.util.Date A66SGCitaDisponibilidadFecha ,
                                           java.util.Date A68SGCitaDisponibilidadHoraInicio ,
                                           java.util.Date A387SGCitaDisponibilidadHoraFin ,
                                           String A333CitaArchivoExtencion ,
                                           int A81SGCitaDisponibilidadProfesionalId ,
                                           int AV98ProfesionalId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int26 = new byte[44];
      Object[] GXv_Object27 = new Object[2];
      scmdbuf = "SELECT T1.[PacienteId], T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T3.[SGSedeDisponibilidadSedeId]" ;
      scmdbuf += " AS SGCitaDisponibilidadSedeId, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T1.[CitaArchivoExtencion], T3.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId," ;
      scmdbuf += " T3.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T3.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha," ;
      scmdbuf += " T1.[CitaId], T1.[CitaEstadoPago], T1.[CitaEstadoCita], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T5.[SedeNombre] AS SGCitaDisponibilidadSedeNombre," ;
      scmdbuf += " T4.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T2.[PacienteNombres], T2.[PacienteApellidoMaterno], T2.[PacienteApellidoPaterno], T2.[PacienteNroDocumento]," ;
      scmdbuf += " T1.[CitaCode] FROM ((((([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId])" ;
      scmdbuf += " INNER JOIN [Especialidad] T4 ON T4.[EspecialidadId] = T3.[EspecialidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica]" ;
      scmdbuf += " T6 ON T6.[ClinicaId] = T5.[ClinicaId])" ;
      if ( ! (GXutil.strcmp("", AV108Wpbandejacitasds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[CitaCode] like '%' + ?) or ( T2.[PacienteNroDocumento] like '%' + ?) or ( T2.[PacienteApellidoPaterno] like '%' + ?) or ( T2.[PacienteApellidoMaterno] like '%' + ?) or ( T2.[PacienteNombres] like '%' + ?) or ( T4.[EspecialidadNombre] like '%' + ?) or ( T5.[SedeNombre] like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( 'sin pago' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'S') or ( 'pendiente' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'P') or ( 'pagado' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'G'))");
      }
      else
      {
         GXv_int26[0] = (byte)(1) ;
         GXv_int26[1] = (byte)(1) ;
         GXv_int26[2] = (byte)(1) ;
         GXv_int26[3] = (byte)(1) ;
         GXv_int26[4] = (byte)(1) ;
         GXv_int26[5] = (byte)(1) ;
         GXv_int26[6] = (byte)(1) ;
         GXv_int26[7] = (byte)(1) ;
         GXv_int26[8] = (byte)(1) ;
         GXv_int26[9] = (byte)(1) ;
         GXv_int26[10] = (byte)(1) ;
         GXv_int26[11] = (byte)(1) ;
         GXv_int26[12] = (byte)(1) ;
         GXv_int26[13] = (byte)(1) ;
         GXv_int26[14] = (byte)(1) ;
         GXv_int26[15] = (byte)(1) ;
         GXv_int26[16] = (byte)(1) ;
      }
      if ( ! (0==AV109Wpbandejacitasds_2_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int26[17] = (byte)(1) ;
      }
      if ( ! (0==AV110Wpbandejacitasds_3_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int26[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV111Wpbandejacitasds_4_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] like ?)");
      }
      else
      {
         GXv_int26[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV112Wpbandejacitasds_5_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] = ?)");
      }
      else
      {
         GXv_int26[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV113Wpbandejacitasds_6_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int26[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV114Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int26[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV115Wpbandejacitasds_8_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int26[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV116Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int26[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV117Wpbandejacitasds_10_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int26[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV118Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int26[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV119Wpbandejacitasds_12_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int26[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Wpbandejacitasds_13_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int26[28] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV121Wpbandejacitasds_14_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int26[29] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV122Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int26[30] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV123Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int26[31] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV124Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int26[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV125Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int26[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV126Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int26[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV127Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int26[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV128Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int26[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV129Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int26[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV130Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int26[38] = (byte)(1) ;
      }
      if ( AV131Wpbandejacitasds_24_tfcitaestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV131Wpbandejacitasds_24_tfcitaestadocita_sels, "T1.[CitaEstadoCita] IN (", ")")+")");
      }
      if ( AV132Wpbandejacitasds_25_tfcitaestadopago_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV132Wpbandejacitasds_25_tfcitaestadopago_sels, "T1.[CitaEstadoPago] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV133Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int26[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV134Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int26[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) && ( ! (GXutil.strcmp("", AV135Wpbandejacitasds_28_tfcitaarchivoextencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] like ?)");
      }
      else
      {
         GXv_int26[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV136Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] = ?)");
      }
      else
      {
         GXv_int26[42] = (byte)(1) ;
      }
      if ( AV99SecRoleId != 1 )
      {
         addWhere(sWhereString, "(T3.[ProfesionalId] = ?)");
      }
      else
      {
         GXv_int26[43] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.[CitaArchivoExtencion]" ;
      GXv_Object27[0] = scmdbuf ;
      GXv_Object27[1] = GXv_int26 ;
      return GXv_Object27 ;
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
                  return conditional_P003U2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.util.Date)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (java.util.Date)dynConstraints[29] , (java.util.Date)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , (java.util.Date)dynConstraints[43] , (java.util.Date)dynConstraints[44] , (java.util.Date)dynConstraints[45] , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() );
            case 1 :
                  return conditional_P003U3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.util.Date)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (java.util.Date)dynConstraints[29] , (java.util.Date)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , (java.util.Date)dynConstraints[43] , (java.util.Date)dynConstraints[44] , (java.util.Date)dynConstraints[45] , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() );
            case 2 :
                  return conditional_P003U4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.util.Date)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (java.util.Date)dynConstraints[29] , (java.util.Date)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , (java.util.Date)dynConstraints[43] , (java.util.Date)dynConstraints[44] , (java.util.Date)dynConstraints[45] , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() );
            case 3 :
                  return conditional_P003U5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.util.Date)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (java.util.Date)dynConstraints[29] , (java.util.Date)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , (java.util.Date)dynConstraints[43] , (java.util.Date)dynConstraints[44] , (java.util.Date)dynConstraints[45] , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() );
            case 4 :
                  return conditional_P003U6(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.util.Date)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (java.util.Date)dynConstraints[29] , (java.util.Date)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , (java.util.Date)dynConstraints[43] , (java.util.Date)dynConstraints[44] , (java.util.Date)dynConstraints[45] , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() );
            case 5 :
                  return conditional_P003U7(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.util.Date)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (java.util.Date)dynConstraints[29] , (java.util.Date)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , (java.util.Date)dynConstraints[43] , (java.util.Date)dynConstraints[44] , (java.util.Date)dynConstraints[45] , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() );
            case 6 :
                  return conditional_P003U8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.util.Date)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (java.util.Date)dynConstraints[29] , (java.util.Date)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , (java.util.Date)dynConstraints[43] , (java.util.Date)dynConstraints[44] , (java.util.Date)dynConstraints[45] , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() );
            case 7 :
                  return conditional_P003U9(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.util.Date)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (java.util.Date)dynConstraints[29] , (java.util.Date)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , (java.util.Date)dynConstraints[43] , (java.util.Date)dynConstraints[44] , (java.util.Date)dynConstraints[45] , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() );
            case 8 :
                  return conditional_P003U10(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.util.Date)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (java.util.Date)dynConstraints[29] , (java.util.Date)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , (java.util.Date)dynConstraints[43] , (java.util.Date)dynConstraints[44] , (java.util.Date)dynConstraints[45] , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003U2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003U3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003U4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003U5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003U6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003U7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003U8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003U9", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P003U10", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = GXutil.resetDate(rslt.getGXDateTime(10));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(12);
               ((String[]) buf[16])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = GXutil.resetDate(rslt.getGXDateTime(10));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(12);
               ((String[]) buf[16])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = GXutil.resetDate(rslt.getGXDateTime(10));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(12);
               ((String[]) buf[16])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = GXutil.resetDate(rslt.getGXDateTime(10));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(12);
               ((String[]) buf[16])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[8])[0] = GXutil.resetDate(rslt.getGXDateTime(8));
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[10])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(10);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((int[]) buf[14])[0] = rslt.getInt(11);
               ((String[]) buf[15])[0] = rslt.getString(12, 1);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getVarchar(14);
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = GXutil.resetDate(rslt.getGXDateTime(10));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(12);
               ((String[]) buf[16])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = GXutil.resetDate(rslt.getGXDateTime(10));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(12);
               ((String[]) buf[16])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = GXutil.resetDate(rslt.getGXDateTime(10));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(12);
               ((String[]) buf[16])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((java.util.Date[]) buf[8])[0] = GXutil.resetDate(rslt.getGXDateTime(8));
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[10])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(10);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((int[]) buf[14])[0] = rslt.getInt(11);
               ((String[]) buf[15])[0] = rslt.getString(12, 1);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(13, 1);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getVarchar(14);
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
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
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[61]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[62]).intValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 15);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 15);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[73]);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[74]);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[75], true);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[76], true);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 80);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 80);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[83], true);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[84], true);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 30);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 30);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[61]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[62]).intValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 15);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 15);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[73]);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[74]);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[75], true);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[76], true);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 80);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 80);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[83], true);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[84], true);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 30);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 30);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[61]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[62]).intValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 15);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 15);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[73]);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[74]);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[75], true);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[76], true);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 80);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 80);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[83], true);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[84], true);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 30);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 30);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[61]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[62]).intValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 15);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 15);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[73]);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[74]);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[75], true);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[76], true);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 80);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 80);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[83], true);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[84], true);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 30);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 30);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[61]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[62]).intValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 15);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 15);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[73]);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[74]);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[75], true);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[76], true);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 80);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 80);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[83], true);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[84], true);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 30);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 30);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[61]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[62]).intValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 15);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 15);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[73]);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[74]);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[75], true);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[76], true);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 80);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 80);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[83], true);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[84], true);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 30);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 30);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[61]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[62]).intValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 15);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 15);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[73]);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[74]);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[75], true);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[76], true);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 80);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 80);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[83], true);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[84], true);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 30);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 30);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               return;
            case 7 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[61]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[62]).intValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 15);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 15);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[73]);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[74]);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[75], true);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[76], true);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 80);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 80);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[83], true);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[84], true);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 30);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 30);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               return;
            case 8 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[61]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[62]).intValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 15);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 15);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[73]);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[74]);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[75], true);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[76], true);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 80);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 80);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[83], true);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[84], true);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 30);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 30);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               return;
      }
   }

}

