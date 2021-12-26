import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl} from '@angular/forms';
import { EditorModule } from 'primeng/editor';

@Component({
  selector: 'app-Compose',
  templateUrl: './Compose.component.html',
  styleUrls: ['./Compose.component.css']
})
export class ComposeComponent implements OnInit {

  constructor() { }
  default="Hello";
  ngOnInit() {
  }


sendemail(){

}
}
