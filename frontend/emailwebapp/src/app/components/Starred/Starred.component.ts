import { Component, OnInit } from '@angular/core';
import { ComponentscontrollerService } from '../componentscontroller.service';
import { Email } from '../Email';

@Component({
  selector: 'app-Starred',
  templateUrl: './Starred.component.html',
  styleUrls: ['./Starred.component.css']
})
export class StarredComponent implements OnInit {

  Sentemails:Email[];

  page:number=1;

  size:number=5;
  elenum:number;

  constructor(private controll:ComponentscontrollerService) {
    this.Sentemails=this.controll.draftEmails;
  this.elenum=this.Sentemails.length
    console.log(this.Sentemails)
  }
  ngOnInit(): void {
  }

  getDraftEmails(){
  }
  clippage(){}

}
