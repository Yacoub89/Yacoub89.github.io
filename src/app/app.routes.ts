import { ProjectsComponent } from './projects/projects.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home-component';
import {Routes, RouterModule} from "@angular/router";
import {AppComponent} from "./app.component";
import {ModuleWithProviders} from "@angular/core";




const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'about',
    component: AboutComponent
  },
  {
    path: 'contact',
    component: ContactComponent
  },
  {
    path: 'home',
    component: HomeComponent
  }
  ,
  {
    path: 'projects',
    component: ProjectsComponent
  }
];


export const routing: ModuleWithProviders = RouterModule.forRoot(routes);
