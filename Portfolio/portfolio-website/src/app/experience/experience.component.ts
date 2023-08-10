import { Component, Input } from '@angular/core';

@Component({
  selector: 'experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent {
  @Input() position = ""; 
  @Input() time = ""; 
  @Input() company = ""; 
}
