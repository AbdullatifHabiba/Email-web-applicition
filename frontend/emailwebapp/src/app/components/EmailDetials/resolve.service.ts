import { InboxComponent } from './../inbox/inbox.component';
import { ComponentscontrollerService } from './../componentscontroller.service';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router } from '@angular/router';
import { Email } from '../Email';
import { TrashComponent } from '../Trash/Trash.component';
import { StarredComponent } from '../Starred/Starred.component';
import { DraftsComponent } from '../Drafts/Drafts.component';
import { SentItemsComponent } from '../SentItems/SentItems.component';

@Injectable({
  providedIn: 'root'
})

export class ResolveService implements Resolve<Email> {

  constructor(
    private emailService: ComponentscontrollerService,
    private router: Router
  ) { }

  public resolve(route: ActivatedRouteSnapshot ): any {
    const { id } = route.params;
    const parent=route.parent?.routeConfig?.path;
    console.log(parent);
    switch(parent){
     case 'inbox':return this.getinboxemail(+id);
     case 'Drafts':return this.getdraftemail(+id);
     case 'Star':return this.getstaremail(+id);
     case 'Trash':return this.gettrashemail(+id);
     case 'SentItems':return this.getsentemails(+id);



    }

   // return this.emailService.getemaildetails(+id)
  }

  getinboxemail(index:number){
    const list=new InboxComponent(this.emailService).list;
    return list[index];
  }
  gettrashemail(index:number){
    const list=new TrashComponent(this.emailService).list;
    return list[index];
  }
  getstaremail(index:number){
    const list=new StarredComponent(this.emailService).Sentemails;
    return list[index];
  }
  getdraftemail(index:number){
    const list=new DraftsComponent(this.emailService).DraftEmails;
    return list[index];
  }
  getsentemails(index:number){
    const list=new SentItemsComponent(this.emailService).Sentemails;
    return list[index];
  }
}
