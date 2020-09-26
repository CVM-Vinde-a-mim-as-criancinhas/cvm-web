import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from '../component/dashboard/dashboard.component';
import {AgendaComponent} from '../component/agenda/agenda.component';
import {TransparenciaComponent} from '../component/transparencia/transparencia.component';
import {NoticiaComponent} from '../component/noticia/noticia.component';
import {IndexComponent} from '../component/index/index.component';
import { ACvmComponent } from '../component/a-cvm/a-cvm.component';
import { EducacaoInfantilComponent } from '../component/educacao-infantil/educacao-infantil.component';
import { AcolhimentoInstitucionalComponent } from '../component/acolhimento-institucional/acolhimento-institucional.component';
import { CasCentroAtendimentoSocialComponent } from '../component/cas-centro-atendimento-social/cas-centro-atendimento-social.component';

const routes: Routes = [
  {path: 'dashboard', component: DashboardComponent},
  {path: 'agenda', component: AgendaComponent},
  {path: 'transparencia', component: TransparenciaComponent},
  {path: 'noticia', component: NoticiaComponent},
  {path: 'index', component: IndexComponent},
  {path: 'acvm', component: ACvmComponent},
  {path: 'educacaoinfantil', component: EducacaoInfantilComponent},
  {path: 'acolhimentoinstitucional', component: AcolhimentoInstitucionalComponent},
  {path: 'cascentroatendimentosocial', component: CasCentroAtendimentoSocialComponent},
  {path: '', pathMatch: 'full', redirectTo: 'index'}
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
