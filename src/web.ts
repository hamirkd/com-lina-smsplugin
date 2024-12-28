import { WebPlugin } from '@capacitor/core';

import type { smspluginPlugin } from './definitions';

export class smspluginWeb extends WebPlugin implements smspluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
