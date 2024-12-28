import { registerPlugin } from '@capacitor/core';

import type { smspluginPlugin } from './definitions';

const smsplugin = registerPlugin<smspluginPlugin>('smsplugin', {
  web: () => import('./web').then((m) => new m.smspluginWeb()),
});

export * from './definitions';
export { smsplugin };
